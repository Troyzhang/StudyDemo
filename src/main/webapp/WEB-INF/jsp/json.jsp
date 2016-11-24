<%@ page import="org.springframework.web.util.HtmlUtils"%>
<%@ page contentType="application/json;charset=UTF-8" language="java" %>
<%-- 这个文件是用来接收action?type=json的数据 --%>
<%
//String PF500MClient = request.getHeader("PF500MClient");
String result = request.getAttribute("result").toString() ;
String unescape = request.getParameter("unescape");
if(unescape!=null && unescape.equals("1")){

    result = HtmlUtils.htmlUnescape(result).replaceAll("\"" , "\\\\\"");
}
String var = request.getParameter("var");
if(var!=null && !var.trim().equals("")){
    result = "var "+var+"="+result;
}
out.print(result);
%>

