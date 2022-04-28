package com.wuyefei.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//use @WebServlet -- more easy - no xml code
/*@WebServlet(
        name="JDBCDemoServlet",
        urlPatterns = {"/jdbc","/jdbc2","/jdbc.do"},
        initParams = {
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="admin123456789")
        },
        loadOnStartup = 1
)*/
public class JDBCDemoServlet extends HttpServlet {
  Connection con=null;
  public void init(){
     // String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
     // String url="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
     // String username="sa";
     // String password="admin123456789";

      //Demo #2 - code
      //step 1 get config
      ServletConfig config=getServletConfig();

      //step 2 - use cofig to get init param
      String driver = config.getInitParameter("driver");//get <param-name>driver</param-name>
      String url = config.getInitParameter("url");//get  <param-name>url</param-name>
      String username = config.getInitParameter("username");//get  <param-name>username</param-name>
      String password = config.getInitParameter("password");//get <param-name>password</param-name>


      try {
          Class.forName(driver);
          con= DriverManager.getConnection(url,username,password);

          //System.out.println("con in init()"+con);//for test
      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }
  }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //way 1 - create connection within doget --bad idea
       //dont create here - use here to do insert , update , delete , select
        //System.out.println("con in doGet()"+con);//for test

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void destroy(){
      //call when tomcat stop
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
