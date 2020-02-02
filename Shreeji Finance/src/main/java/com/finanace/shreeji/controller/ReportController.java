package com.finanace.shreeji.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.bo.Customer;
import com.finanace.shreeji.bo.Financer;
import com.finanace.shreeji.bo.Lead;
import com.finanace.shreeji.bo.Loan;
import com.finanace.shreeji.bo.Vehicle;
import com.finanace.shreeji.controller.dto.ReportRequest;
import com.finanace.shreeji.service.LeadManagementService;

@Controller
public class ReportController {

	@Autowired
	private LeadManagementService leadManagementService;
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView vielReportLandingPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/report");
		return modelAndView;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/report/download", method = RequestMethod.POST)
	public ResponseEntity<Resource> downloadXLSReport(ReportRequest reportRequest,HttpServletRequest request,
            HttpServletResponse response) {
		String fromDate = reportRequest.getFromDate();
		String toDate = reportRequest.getToDate();

		List<Lead> reportServiceData = leadManagementService.getLeadsBetweenDates(fromDate, toDate);
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+"Report_Beteen_"+fromDate+"_to_"+toDate+".xlsx\"");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Lead Status Created Between "+ fromDate + " And "+toDate);
        
        Row infoRow = sheet.createRow(0);
        Cell infoCell = infoRow.createCell(0);
        infoCell.setCellValue("From Date : ");
        
        infoCell = infoRow.createCell(1);
        infoCell.setCellValue(fromDate);
        
        infoCell = infoRow.createCell(2);
        infoCell.setCellValue("To Date : ");
        
        infoCell = infoRow.createCell(3);
        infoCell.setCellValue(toDate);
        
        Row header = sheet.createRow(1);
        
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("LEAD ID");
        headerCell.setCellStyle(headerStyle);
         
        headerCell = header.createCell(1);
        headerCell.setCellValue("STATUS");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(2);
        headerCell.setCellValue("AGENT NAME");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(3);
        headerCell.setCellValue("INQUIRY DATE");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(4);
        headerCell.setCellValue("CUSTOMER NAME");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(5);
        headerCell.setCellValue("CUSTOMER PRIMARY MOBILE NUMBER");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(6);
        headerCell.setCellValue("CUSTOMER SECONDARY MOBILE NUMBER");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(7);
        headerCell.setCellValue("CUSTOMER VILLAGE");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(8);
        headerCell.setCellValue("CUSTOMER TALUKA");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(9);
        headerCell.setCellValue("CUSTOMER DISTRICT");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(10);
        headerCell.setCellValue("FINANCER BANK NAME");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(11);
        headerCell.setCellValue("FINANCER BANK EXECUTIVE NAME");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(12);
        headerCell.setCellValue("FINANCER BANK EXECUTIVE PHONE NUMBER");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(13);
        headerCell.setCellValue("AGREEMENT DONE ?");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(14);
        headerCell.setCellValue("VEHICLE NAME");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(15);
        headerCell.setCellValue("VEHICLE CONDITION");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(16);
        headerCell.setCellValue("VEHICLE REGISTRATION NUMBER");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(17);
        headerCell.setCellValue("VEHICLE MANUFACTURE YEAR");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(18);
        headerCell.setCellValue("VEHICLE_TYPE");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(19);
        headerCell.setCellValue("LOAN AMOUNT");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(20);
        headerCell.setCellValue("LOAN NUMBER");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(21);
        headerCell.setCellValue("LOAN DATE");
        headerCell.setCellStyle(headerStyle);
        
        
        for(int i=0 ; i < reportServiceData.size() ; i++){
        	Lead currentLead = reportServiceData.get(i);
        	Row dataRow = sheet.createRow(i+2);

            Cell dataCell = dataRow.createCell(0);
            dataCell.setCellValue(currentLead.getId());
             
            dataCell = dataRow.createCell(1);
            dataCell.setCellValue(currentLead.getStatus());
            
            dataCell = dataRow.createCell(2);
            dataCell.setCellValue(currentLead.getGivenBy());
            
            dataCell = dataRow.createCell(3);
            dataCell.setCellValue(currentLead.getInquiryDate());

            Customer leadCustomer = currentLead.getCustomer();

            dataCell = dataRow.createCell(4);
            dataCell.setCellValue(leadCustomer.getName());

            dataCell = dataRow.createCell(5);
            dataCell.setCellValue(leadCustomer.getMobileNumber1());

            dataCell = dataRow.createCell(6);
            dataCell.setCellValue(leadCustomer.getMobileNumber2());

            dataCell = dataRow.createCell(7);
            dataCell.setCellValue(leadCustomer.getVillage());

            dataCell = dataRow.createCell(8);
            dataCell.setCellValue(leadCustomer.getTaluka());

            dataCell = dataRow.createCell(9);
            dataCell.setCellValue(leadCustomer.getDistrict());
            
            Financer leadFinancer = currentLead.getFinancer();
            
            dataCell = dataRow.createCell(10);
            dataCell.setCellValue(leadFinancer.getBankName());

            dataCell = dataRow.createCell(11);
            dataCell.setCellValue(leadFinancer.getExecutiveName());

            dataCell = dataRow.createCell(12);
            dataCell.setCellValue(leadFinancer.getMobileNumber());

            dataCell = dataRow.createCell(13);
            dataCell.setCellValue(leadFinancer.getAgreementDone());

            Vehicle vehicle = currentLead.getVehicle();
            
            dataCell = dataRow.createCell(14);
            dataCell.setCellValue(vehicle.getName());
            
            dataCell = dataRow.createCell(15);
            dataCell.setCellValue(vehicle.getCondition());

            dataCell = dataRow.createCell(16);
            dataCell.setCellValue(vehicle.getRegistrationNumber());

            dataCell = dataRow.createCell(17);
            dataCell.setCellValue(vehicle.getManufactureYear());

            dataCell = dataRow.createCell(18);
            dataCell.setCellValue(vehicle.getType());

            Loan loan = currentLead.getLoan();
            
            dataCell = dataRow.createCell(19);
            dataCell.setCellValue(loan.getLoanAmount());
            
            dataCell = dataRow.createCell(20);
            dataCell.setCellValue(loan.getLoanNumber());
            
            dataCell = dataRow.createCell(21);
            dataCell.setCellValue(loan.getLoanDate());        	
        }
        
        
        
/*        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
*/
        
        try {
        	ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            workbook.close();
            
            return ResponseEntity.ok()
                    .contentLength(new ByteArrayResource(out.toByteArray()).contentLength())
                    .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                    .body(new ByteArrayResource(out.toByteArray()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		return null;
	}
	
	
}
