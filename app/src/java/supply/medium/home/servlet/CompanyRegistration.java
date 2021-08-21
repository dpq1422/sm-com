package supply.medium.home.servlet;

// Import required java libraries
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import supply.medium.home.database.AccountPolicyMaster;
import supply.medium.home.database.BusinessCategoryMaster;
import supply.medium.home.database.CompanyBusinessCategoryMaster;
import supply.medium.home.database.CompanyMailingAddressMaster;
import supply.medium.home.database.CompanyMaster;
import supply.medium.home.database.UserMailingAddressMaster;
import supply.medium.home.database.UserMaster;
import supply.medium.home.database.UserSettingMaster;
import supply.medium.home.mailing.ActivationMailing;
import supply.medium.home.mailing.HTMLMailComposer;
import supply.medium.marketing.database.MarketingPersonBusinessMaster;
import supply.medium.utility.CreateFolder;
import supply.medium.utility.FileCopy;
import supply.medium.utility.SmProperties;
import supply.medium.utility.MemoryTest;

public class CompanyRegistration extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    //private int maxFileSize = 50 * 1024;
    //private int maxMemSize = 4 * 1024;
    private File file;

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, java.io.IOException {
        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<br/>line no : 45");
        if (!isMultipart) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No file uploaded</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        out.println("<br/>line no : 58");

        ServletFileUpload upload = new ServletFileUpload(factory);
        out.println("<br/>line no : 61");

        try {
            List fileItems = upload.parseRequest(request);

            Iterator i = fileItems.iterator();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            String type = null;
            String logo = null;
            String companyName = null;
            String companyId = null;
            String businessCategory = null;
            String division = null;
            String unit = null;
            String branch = null;
            String country = null;
            String address = null;
            String city = null;
            String state = null;
            String zipcode = null;
            String branch2 = null;
            String country2 = null;
            String address2 = null;
            String city2 = null;
            String state2 = null;
            String zipcode2 = null;
            String branch3 = null;
            String country3 = null;
            String address3 = null;
            String city3 = null;
            String state3 = null;
            String zipcode3 = null;
            String firstName = null;
            String lastName = null;
            String title = null;
            String department = null;
            String managerSupervisor = null;
            String phone = null;
            String cell = null;
            String fax = null;
            String email = null;
            String password = null;
            String addressCount = null;
            String marketing_key=null;
            FileItem forFile = null;
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (fi.isFormField()) {
                    if (fi.getFieldName().equals("signupas")) {
                        type = fi.getString();
                        type="Buyers/Suppliers";
                    } //          else if(fi.getFieldName().equals("logo"))
                    //          {
                    //              type=fi.getString();
                    //          }
                    else if (fi.getFieldName().equals("companyname")) {
                        companyName = fi.getString();
                    } else if (fi.getFieldName().equals("companyid")) {
                        companyId = fi.getString();
                    } else if (fi.getFieldName().equals("marketing_key")) {
                        marketing_key = fi.getString();
                    } else if (fi.getFieldName().equals("businesscategory2")) {
                        businessCategory = fi.getString();
                    } else if (fi.getFieldName().equals("divisionname")) {
                        division = fi.getString();
                    } else if (fi.getFieldName().equals("unitname")) {
                        unit = fi.getString();
                    } else if (fi.getFieldName().equals("branch_0")) {
                        branch = fi.getString();
                    } else if (fi.getFieldName().equals("countryregion_0")) {
                        country = fi.getString();
                    } else if (fi.getFieldName().equals("address_0")) {
                        address = fi.getString();
                    } else if (fi.getFieldName().equals("city_0")) {
                        city = fi.getString();
                    } else if (fi.getFieldName().equals("state_0")) {
                        state = fi.getString();
                    } else if (fi.getFieldName().equals("zipcode_0")) {
                        zipcode = fi.getString();
                    } else if (fi.getFieldName().equals("firstname")) {
                        firstName = fi.getString();
                    } else if (fi.getFieldName().equals("lastname")) {
                        lastName = fi.getString();
                    } else if (fi.getFieldName().equals("title")) {
                        title = fi.getString();
                    } else if (fi.getFieldName().equals("department")) {
                        department = fi.getString();
                    } else if (fi.getFieldName().equals("managersupervisor")) {
                        managerSupervisor = fi.getString();
                    } else if (fi.getFieldName().equals("phone")) {
                        phone = fi.getString();
                    } else if (fi.getFieldName().equals("cell")) {
                        cell = fi.getString();
                    } else if (fi.getFieldName().equals("fax")) {
                        fax = fi.getString();
                    } else if (fi.getFieldName().equals("email")) {
                        email = fi.getString();
                    } else if (fi.getFieldName().equals("password")) {
                        password = fi.getString();
                    } else if (fi.getFieldName().equals("branch_1")) {
                        branch2 = fi.getString();
                    } else if (fi.getFieldName().equals("countryregion_1")) {
                        country2 = fi.getString();
                    } else if (fi.getFieldName().equals("address_1")) {
                        address2 = fi.getString();
                    } else if (fi.getFieldName().equals("city_1")) {
                        city2 = fi.getString();
                    } else if (fi.getFieldName().equals("state_1")) {
                        state2 = fi.getString();
                    } else if (fi.getFieldName().equals("zipcode_1")) {
                        zipcode2 = fi.getString();
                    } else if (fi.getFieldName().equals("branch_2")) {
                        branch3 = fi.getString();
                    } else if (fi.getFieldName().equals("countryregion_2")) {
                        country3 = fi.getString();
                    } else if (fi.getFieldName().equals("address_2")) {
                        address3 = fi.getString();
                    } else if (fi.getFieldName().equals("city_2")) {
                        city3 = fi.getString();
                    } else if (fi.getFieldName().equals("state_2")) {
                        state3 = fi.getString();
                    } else if (fi.getFieldName().equals("zipcode_2")) {
                        zipcode3 = fi.getString();
                    } else if (fi.getFieldName().equals("addresscount")) {
                        addressCount = fi.getString();
                    }

                } else if (!fi.isFormField()) {
                    forFile = fi;

                }
            }
            out.println("<br/>line no : 198");

            String bcid[] = businessCategory.split(",");
            int result = CompanyMaster.insert(type, logo, companyName, companyId,
                    division, unit);
            int companyKey = CompanyMaster.showLastCompanyKeyByCompanyId(companyId);

            for (int ii = 0; ii < bcid.length; ii++) {
                CompanyBusinessCategoryMaster.insert("" + companyKey, BusinessCategoryMaster.showBusinessCategoryKeyByName(bcid[ii]));
            }
            out.println("<br/>line no : 208");

            String confirmationValue = System.currentTimeMillis() + "";

            int result2 = UserMaster.insert(companyKey + "", "Admin", firstName, lastName, " ",
                    title, department, managerSupervisor, phone, cell, fax, email,
                    password, confirmationValue);

            int result3 = CompanyMailingAddressMaster.insert(companyKey + "", branch,
                    country, address, city, state,
                    zipcode, "Permanent", "0");
            int userKey = UserMaster.showLastUserKeyByEmail(email);
            int result5 = UserMailingAddressMaster.insert(userKey + "", country, address, city, state, zipcode);
            int result6 = AccountPolicyMaster.insert(companyKey + "", userKey + "");

            UserSettingMaster.insert(userKey + "");
            out.println("<br/>line no : 224");

            if (addressCount.equals("2")) {
                int result4 = CompanyMailingAddressMaster.insert(companyKey + "", branch2,
                        country2, address2, city2, state2,
                        zipcode2, "Permanent", "0");
            } else if (addressCount.equals("3")) {
                int result4 = CompanyMailingAddressMaster.insert(companyKey + "", branch2,
                        country2, address2, city2, state2,
                        zipcode2, "Permanent", "0");
                int result7 = CompanyMailingAddressMaster.insert(companyKey + "", branch3,
                        country3, address3, city3, state3,
                        zipcode3, "Permanent", "0");
            }
            out.println("<br/>line no : 238");

            String[] to = {email};

            String sub = "SupplyMedium login activation link";

            HTMLMailComposer composer = new HTMLMailComposer();

            String message = composer.composeCompanyActivationMail(UUID.randomUUID().toString(), email, firstName, companyName, confirmationValue);

            out.println("<br/>line no : 248");
            composer = null;

            ActivationMailing am = new ActivationMailing();
            out.println("<br/>line no : 252");

            am.composeAndSendMail(to, sub, message.toString(), "SM Registration");

            out.println("<br/>line no : 256");
            /**
             * *******************create directory************************
             */
            SmProperties.folderPath = request.getRealPath("")+ File.separator + "cropData" + File.separator;
            SmProperties.folderPath=SmProperties.folderPath.replace(File.separator+"app"+File.separator, File.separator+"zData"+File.separator);
            CreateFolder companies = new CreateFolder();
            companies.createFolder(SmProperties.folderPath + "companies");
            out.println("<br/>line no : 264");

            CreateFolder users = new CreateFolder();
            users.createFolder(SmProperties.folderPath + "users");
            out.println("<br/>line no : 268");

            filePath = SmProperties.folderPath + "company-" + companyKey + File.separator;

            CreateFolder createCompanyFolder = new CreateFolder();
            createCompanyFolder.createFolder(filePath);
            out.println("<br/>line no : 274");

            CreateFolder createCompanyAd = new CreateFolder();
            createCompanyAd.createFolder(filePath + "ad");
            out.println("<br/>line no : 278");

            CreateFolder createCompanyUserFeed = new CreateFolder();
            createCompanyUserFeed.createFolder(filePath + "user feed");
            out.println("<br/>line no : 282");

            CreateFolder createCompanyInternalFeed = new CreateFolder();
            createCompanyInternalFeed.createFolder(filePath + "internal feed");
            out.println("<br/>line no : 286");

            CreateFolder createCompanyDepartmentFeed = new CreateFolder();
            createCompanyDepartmentFeed.createFolder(filePath + "department feed");
            out.println("<br/>line no : 290");

            CreateFolder w9forms = new CreateFolder();
            w9forms.createFolder(filePath + "w9forms");
            out.println("<br/>line no : 294");

            CreateFolder transaction = new CreateFolder();
            transaction.createFolder(filePath + "transaction");
            out.println("<br/>line no : 298");

            String source = SmProperties.folderPath + "mugshot.png";
            String target = filePath + "company-" + companyKey + ".png";
            FileCopy.copyCompleteFile(source, target);
            out.println("<br/>line no : 303");

            target = SmProperties.folderPath + "companies" + File.separator + companyKey + ".png";
            FileCopy.copyCompleteFile(source, target);
            out.println("<br/>line no : 307");

            source = SmProperties.folderPath + "no_image_icon.png";
            target = filePath + userKey + ".png";
            FileCopy.copyCompleteFile(source, target);
            out.println("<br/>line no : 312");

            target = SmProperties.folderPath + "users" + File.separator + userKey + ".png";
            FileCopy.copyCompleteFile(source, target);
            out.println("<br/>line no : 316");
            /**
             * ***************Write file****************
             */
            if (forFile.getName() != null && forFile.getName().equals("")) {
                file = new File(filePath + "company-" + companyKey + ".png");
                forFile.write(file);
            }
            out.println("<br/>line no : 324");
            source = filePath + "company-" + companyKey + ".png";
            target = SmProperties.folderPath + "companies" + File.separator + companyKey + ".png";
            FileCopy.copyCompleteFile(source, target);
            out.println("<br/>line no : 328");

            MarketingPersonBusinessMaster.insert(marketing_key, ""+companyKey);
            out.println("<br/>line no : 330");
            /**
             * *******************end write file***********************
             */
            out.println("</body>");
            out.println("</html>");
            out.println("<br/>line no : 337");
            MemoryTest.test("footer start");
            System.gc();
            MemoryTest.test("footer end");
            out.println("<br/>line no : 341");
            response.sendRedirect("emailSuccessResponse.jsp");
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
    }

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, java.io.IOException {

        throw new ServletException("GET method used with "
                + getClass().getName() + ": POST method required.");
    }
}