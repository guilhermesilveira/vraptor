package br.com.caelum.vraptor.deserialization;

import br.com.caelum.vraptor.interceptor.TypeNameExtractor;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.serialization.xstream.VRaptorClassMapper;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

/**
 * Implementation of default XStream configuration
 *
 * @author Rafael Viana
 */
@ApplicationScoped
@Component
public class XStreamBuilderImpl implements XStreamBuilder {

	private final XStreamConverters converters;
	private final TypeNameExtractor extractor;
	
	public XStreamBuilderImpl(XStreamConverters converters, TypeNameExtractor extractor)
	{
		this.converters = converters;
		this.extractor = extractor;
	}

	@Override
	public XStream xmlInstance() {
		XStream xstream = new XStream() {
			{setMode(NO_REFERENCES);}
			@Override
			protected MapperWrapper wrapMapper(MapperWrapper next) {
				return new VRaptorClassMapper(next, extractor);
			}
		};
		converters.registerComponents(xstream);
		return xstream;
	}

	@Override
	public XStream jsonInstance(HierarchicalStreamDriver driver) {
		XStream xstream = new XStream(driver) {
            {setMode(NO_REFERENCES);}
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new VRaptorClassMapper(next, extractor);
            }
        };
		converters.registerComponents(xstream);
		return xstream;
	}
	
}