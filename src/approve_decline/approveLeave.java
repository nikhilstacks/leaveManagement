package approve_decline;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nikhil.DatabaseConnectionMain;

@WebServlet("/approveLeave")
public class approveLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		Logger approve = LogManager.getLogger(approveLeave.class.getName());

		DatabaseConnectionMain connection = new DatabaseConnectionMain();
		Connection connObj = connection.getConnection();

		try {

			if (connObj != null) {

				String qry1 = "update leaves set state='approved' WHERE id=?;";
				String qry2 = "DELETE FROM audit WHERE id=?;";
				
				approve.debug("executing update leaves set state='approved' WHERE id={};", id);
				approve.debug("executing DELETE FROM audit WHERE id={};", id);
				

				PreparedStatement pstmt = connObj.prepareStatement(qry1,
						Statement.RETURN_GENERATED_KEYS);
				PreparedStatement pstmt2 = connObj.prepareStatement(qry2,
						Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, id);
				pstmt2.setString(1, id);
				pstmt.executeQuery();
				pstmt2.executeQuery();
				approve.debug("leave approved query executed successfully");
				response.sendRedirect("staffAuditLeaveDashboard.jsp");
			}
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}

	}

}
