package br.com.caelum.vraptor.interceptor;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.http.MutableResponse;
import br.com.caelum.vraptor.http.VRaptorResponse;

/**
 * Tests FlashInterceptor
 *
 * @author Lucas Cavalcanti
 * @author Adriano Almeida
 * @author Caires Vinicius
 */
public class FlashInterceptorTest {


	private Mockery mockery;
	private HttpSession session;
	private Result result;
	private MutableResponse response;
	private FlashInterceptor interceptor;
	private InterceptorStack stack;

	@Before
	public void setUp() throws Exception {
		mockery = new Mockery();
		session = mockery.mock(HttpSession.class);
		result = mockery.mock(Result.class);
		stack = mockery.mock(InterceptorStack.class);

		response = new VRaptorResponse(mockery.mock(HttpServletResponse.class));

		interceptor = new FlashInterceptor(session, result, response);
	}

	@Test
	public void shouldDoNothingWhenThereIsNoFlashParameters() throws Exception {

		mockery.checking(new Expectations() {
			{
				one(session).getAttribute(FlashInterceptor.FLASH_INCLUDED_PARAMETERS);
				will(returnValue(null));

				never(result);

				ignoring(anything());
			}
		});

		interceptor.intercept(stack, null, null);
		mockery.assertIsSatisfied();
	}

	@Test
	public void shouldAddAllFlashParametersToResult() throws Exception {

		mockery.checking(new Expectations() {
			{
				one(session).getAttribute(FlashInterceptor.FLASH_INCLUDED_PARAMETERS);
				will(returnValue(Collections.singletonMap("Abc", 1002)));

				one(result).include("Abc", 1002);

				ignoring(anything());
			}
		});

		interceptor.intercept(stack, null, null);
		mockery.assertIsSatisfied();
	}

	@Test
	public void shouldRemoveFlashIncludedParameters() throws Exception {

		mockery.checking(new Expectations() {
			{
				one(session).getAttribute(FlashInterceptor.FLASH_INCLUDED_PARAMETERS);
				will(returnValue(Collections.singletonMap("Abc", 1002)));

				one(session).removeAttribute(FlashInterceptor.FLASH_INCLUDED_PARAMETERS);

				ignoring(anything());
			}
		});

		interceptor.intercept(stack, null, null);
		mockery.assertIsSatisfied();
	}
	@Test
	public void shouldIncludeFlashParametersWhenARedirectHappens() throws Exception {

		mockery.checking(new Expectations() {
			{
				Map<String, Object> parameters = Collections.<String, Object>singletonMap("Abc", 1002);

				one(result).included();
				will(returnValue(parameters));

				one(session).setAttribute(FlashInterceptor.FLASH_INCLUDED_PARAMETERS, parameters);

				allowing(session).getAttribute(FlashInterceptor.FLASH_INCLUDED_PARAMETERS);
				will(returnValue(null));

				ignoring(anything());
			}
		});

		interceptor.intercept(stack, null, null);

		response.sendRedirect("Anything");

		mockery.assertIsSatisfied();
	}
}
