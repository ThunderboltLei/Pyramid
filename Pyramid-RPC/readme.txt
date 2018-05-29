Pyramid-RPC
时间：2014-08-25
说明：用于声明远程调用接口

问题总结：
（1）Question:
javax.servlet.ServletException: Servlet execution threw an exception
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:197)
	org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
java.lang.AbstractMethodError: javax.ws.rs.core.UriBuilder.uri(Ljava&#47;lang&#47;String;)Ljavax&#47;ws&#47;rs&#47;core&#47;UriBuilder;
	javax.ws.rs.core.UriBuilder.fromUri(UriBuilder.java:120)
	com.sun.jersey.spi.container.servlet.ServletContainer.service(ServletContainer.java:669)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:742)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:197)
	org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
	
	Answer:
	此问题是因为是 javax.ws.rs.core.UriBuilder 冲突，在 jersey-spring 内部依赖 jsr311-api 的 jar 和
	jersey-container-grizzly2-http 内部依赖的 javax.ws.rs-api 的 jar 冲突。它们俩都是实现 UriBuilder，
	javax.ws.rs 里面实现是 UriBuilderImpl, jsr311 里面的实现是 JerseyUriBuilder 。依赖的接口和实现不同，
	所以冲突。
	
	所以，在引用依赖时，只引用 jersey-spring 即可，不需要 javax.ws.rs-api 。