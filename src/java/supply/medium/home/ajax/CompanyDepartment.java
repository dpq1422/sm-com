/*
 * 
 * 
 * 
 */
package supply.medium.home.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import supply.medium.home.bean.DepartmentBean;
import supply.medium.home.database.DepartmentMaster;
import supply.medium.home.database.DepartmentPermMaster;
import supply.medium.utility.TestMemory;

/**
 *
 * @author LenovoB560
 */
public class CompanyDepartment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); try { 
            /* TODO output your page here. You may use following sample code. */
            int result = 0;
            if (request.getParameter("eventType").endsWith("addDepartment")) {
                String dkey=System.currentTimeMillis()+"";
                result = DepartmentMaster.insert(dkey,request.getParameter("companyKey"), request.getParameter("departmentName"));
//                result=DepartmentPermMaster.insert(dkey, "1", "1", "1", "1", "1", "0");
            } else if (request.getParameter("eventType").endsWith("updateDepartment")) {
                result = DepartmentMaster.update(request.getParameter("departmentKey"), request.getParameter("departmentName"));
            } else if (request.getParameter("eventType").endsWith("deleteDepartment")) {
                result = DepartmentMaster.delete(request.getParameter("departmentKey"));
            } else if (request.getParameter("eventType").endsWith("showCompanyDepartment")) {
                ArrayList countryList = DepartmentMaster.showCompanyDepartment(request.getParameter("companyKey"));
                DepartmentBean scb = null;
                for (int i = 0; i < countryList.size(); i++) {
                    scb = (DepartmentBean) countryList.get(i);
                    out.print("<option value=" + scb.getDepartmentKey() + ">" + scb.getDepartmentName() + "</option>");
                }
            }
            TestMemory.test("footer start");
                System.gc();
                TestMemory.test("footer end");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
