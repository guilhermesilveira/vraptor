package br.com.caelum.vraptor.deserialization;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;

/**
 *  Interface that defines needed methods to create a configured XStream instance
 *
 * @author Rafael Viana
 */
public interface XStreamBuilder {

	public XStream xmlInstance();
	
	public XStream jsonInstance(HierarchicalStreamDriver driver);
	
}