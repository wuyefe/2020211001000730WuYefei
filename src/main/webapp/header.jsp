<%@ page import="com.wuyefei.model.User" %>
<html>
<head>
    <title>My Online Shop</title>

</head>
<body style="margin:0px;padding:0px;font-family:helvetica;">
<table width="100%" cellpadding="0" cellspacing="0">
    <tr>
        <td height="78" style="background-color:#788dad;
                            border-width:2px;
                            border-style:solid;
                            border-color:black;
                            padding:0px;
                            margin:0px;" valign="bottom">

            <img src="logo.jpg" align="left">
        </td>
    </tr>
    <tr>
        <td height="15" style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;" align="center">
            <a style="color:white;" href="home">Home</a>
            - <a style="color:white;" href="login.jsp">Login</a>
            - <a style="color:white;" href="productList">Product</a>
            - <a style="color:white;" href="#">FAQ</a>
            - <a style="color:white;" href="#">About</a>
            - <a style="color:white;" href="#">Feedback</a>

        </td>
    </tr>
    <tr height="25"><td align="right"><font size="18" color="blue">
        Welcome,
        <%
            //get session attribute
            User user=(User) session.getAttribute("user");//name of attribute
            if(user!=null){
                //print username
                out.println(user.getUsername());
            }else{//print guest

        %>
        <font size="18" color="red"> Guest</font>
        <%}//end of else%>
    </font></td> </tr>
    <tr height="20"><td align="right">
        <%
            //if user in session -- print logout --- others --- no logout
            if(session.getAttribute("user")!=null){
        %>
        <br> <a href="logout">Logout</a><!-- request go to controller - LogoutServlet-->
        <br><a href="#">My Cart</a><br/>
        <%}else{%>
        <a href="register.jsp">Register Here</a>
        <%}//end of else%>
    </td></tr>
</table>
