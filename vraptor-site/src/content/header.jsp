<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="author" content="Caelum"/>
	<meta name="reply-to" content="contato@caelum.com.br"/>
	<meta name="author" content="Design"/>
	<meta name="reply-to" content="lokidg@gmail.com"/>
	${param.extras}
	<meta name="description" content="VRaptor 3 - um framework java para web focado em desenvolvimento rápido"/>
	<meta name="keywords" content="sites, web, desenvolvimento, java, opensource"/>
	<title>V|Raptor - Alta produtividade no Desenvolvimento Web em Java</title>
	<link href="${path }/screen.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="${path }/menu.css" rel="stylesheet" type="text/css" media="screen" />
    <!--[if lt IE 7]>
    <script src="http://ie7-js.googlecode.com/svn/version/2.0(beta3)/IE7.js" type="text/javascript"></script>
    <![endif]-->
</head>

<body>
	<div id="headerWrap">
    	<div id="headerContent">
        	<h1 id="logoVraptor"><span>V|Raptor</span></h1><!-- vraptorlogo-->
            
            <ul id="langMenu">
            	<li><a id="engBtn" href="${path }/en/"><span>ENGLISH</span></a></li>
                <li><a id="ptBtn" href="${path }/"><span>PORTUGUÊS</span></a></li>
            </ul><!-- langMenu-->            
        </div><!-- header content -->
    </div><!-- header wrap-->
    
    <div id="menuWrap">
    	<ul id="menuElements">
        	<li><a id="homeBtn" href="${path }/<fmt:message key='home.link'/>"><span>home</span></a></li>
        	<li><a id="downloadBtn" href="${path }/<fmt:message key='download.link'/>"><span>download</span></a></li>
        	<li><a id="documentacaoBtn" href="${path }/<fmt:message key='documentacao.link'/>"><span>documentação</span></a></li>
        	<li><a id="beneficiosBtn" href="${path }/<fmt:message key='beneficios.link'/>"><span>benefícios</span></a></li>
        	<li><a id="suporteBtn" href="${path }/<fmt:message key='suporte.link'/>"><span>suporte</span></a></li>
        	<li><a id="vraptor2Btn" href="${path }/<fmt:message key='vraptor2.link'/>"><span>vraptor2</span></a></li>
        </ul><!-- menuElements-->
    </div><!-- menuWrap-->