
<%@page import="storage.DBData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="storage.DBData"%>
<jsp:useBean id="obj" class="bean1.SignupBean" />
<jsp:setProperty property="*" name="obj" />

<script type="text/javascript">
    function welcomeMsg(){
        var val=document.getElementById("id1").value;
        if(window.confirm("Signup SuccessFull,Do You Want To Login, Click Ok")){
            window.location.href="index.jsp";
        }
        else{
            
        }
    }
</script>
<%
   int i= DBData.newBidder(obj);
   //String name=(String)(obj.getName());
  // out.print(name);
   if(i==1)
   {%>
   <body onload="welcomeMsg()">
       <input type="hidden" id="id1" value="<%= obj.getName()%>"/>
   </body>
   <%}
   else{
       
   }
%>

    
