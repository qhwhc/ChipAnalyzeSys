package com.ccc.smse.service.impl;

import com.ccc.smse.common.util.ReturnInfoUtil;
import com.ccc.smse.common.util.ReturnUtil;
import com.ccc.smse.dao.ExcelDao;
import com.ccc.smse.pojo.BankModel;
import com.ccc.smse.pojo.ChipData;
import com.ccc.smse.pojo.ChipYield;
import com.ccc.smse.service.ChipDataService;
import com.ccc.smse.service.ChipYieldService;
import com.ccc.smse.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luowenlv on 2018/9/10,15:29
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    private ChipDataService chipDataService;

    @Autowired
    private ChipYieldService chipYieldService;
    SimpleDateFormat fm=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    /**
     *
     * @param fileName
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    public ReturnInfoUtil getExcelInfo(String fileName, MultipartFile file) throws Exception {
        ReturnInfoUtil returnInfoUtil = new ReturnInfoUtil();


        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            return ReturnUtil.error("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet.getRow(0).getPhysicalNumberOfCells() > 10){
            List<ChipData> resultList = new ArrayList<>();
            int[] resultCell = new int[]{0,1,2,6,7,8,9,10,11,12,13,14};//要将表中的哪几列传入数据库中，从0开始计数
            resultList = getSheetVal(sheet, resultCell);
            System.out.println("结果集---"+resultList);
            try{
                for(int i =0;i<resultList.size();i++){
                    chipDataService.save(resultList.get(i));
                }
                returnInfoUtil = ReturnUtil.success("");
            }catch (Exception e){
                e.printStackTrace();
                returnInfoUtil = ReturnUtil.error("数据导入失败");
            }
        }else {
            List<ChipYield> resultList = new ArrayList<>();
            int[] resultCell = new int[]{2,3,4,5};//要将表中的哪几列传入数据库中，从0开始计数
            resultList = getYieldVal(sheet, resultCell);
            System.out.println("结果集---"+resultList);
            try{
                for(int i =0;i<resultList.size();i++){
                    chipYieldService.save(resultList.get(i));
                }
                returnInfoUtil = ReturnUtil.success("");
            }catch (Exception e){
                e.printStackTrace();
                returnInfoUtil = ReturnUtil.error("数据导入失败");
            }
        }
        return returnInfoUtil;
    }

    /**
     *
     * @param sheet
     * @param resultCell 需要将哪些列插入至数据库
     * @return
     */
    public List getSheetVal(Sheet sheet, int[] resultCell){
        List<ChipData> chipDataList = new ArrayList<>();//返回的结果集
        int[] resultIndex = new int[resultCell.length];//存储需要上传字段的下标
        ChipData chipData;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            chipData = new ChipData();
            for (int i = 0;i<row.getPhysicalNumberOfCells();i++){
                String temp = row.getCell(i).toString().trim();
                if(i == 13 || i == 14) temp = fm.format(row.getCell(i).getDateCellValue());
                for (int j=0;j<resultCell.length;j++){
                    if (i==resultCell[j]){
                        switch (i){
                            case 0:
                                chipData.setBatchNumber(temp);
                                break;
                            case 1:
                                chipData.setProductCode(temp);
                                break;
                            case 2:
                                chipData.setVersion(temp);
                                break;
                            case 6:
                                double value = Double.valueOf(temp);
                                int number = (int) value;
                                chipData.setNumberPieces(number);
                                break;
                            case 7:
                                chipData.setProcessPeriod(temp);
                                break;
                            case 8:
                                chipData.setProcess(temp);
                                break;
                            case 9:
                                chipData.setProcessConditions(temp);
                                break;
                            case 10:
                                chipData.setWorkCenter(temp);
                                break;
                            case 11:
                                chipData.setWorkUnit(temp);
                                break;
                            case 12:
                                chipData.setOperator(temp);
                                break;
                            case 13:
                                chipData.setStartTime(temp);
                                break;
                            case 14:
                                chipData.setEndTime(temp);
                                break;
                            default:
                                break;
                        }
                    }else{
                        continue;
                    }
                }
            }
            chipDataList.add(chipData);
        }
        return chipDataList;
    }


    public List getYieldVal(Sheet sheet, int[] resultCell){
        List<ChipYield> chipYieldList = new ArrayList<>();//返回的结果集
        int[] resultIndex = new int[resultCell.length];//存储需要上传字段的下标
        ChipYield chipYield;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            chipYield = new ChipYield();
            for (int i = 0;i<row.getPhysicalNumberOfCells();i++){
                String temp = row.getCell(i).toString().trim();
                try {
                    for (int j=0;j<resultCell.length;j++){
                        if (i==resultCell[j]){
                            switch (i){
                                case 2:
                                    chipYield.setBatchNumber(temp);
                                    break;
                                case 3:
                                    double value = Double.valueOf(temp);
                                    int number = (int) value;
                                    chipYield.setNumberPieces(number);
                                    break;
                                case 4:
                                    double value1 = Double.valueOf(temp);
                                    int number1 = (int) value1;
                                    chipYield.setParticles(number1);
                                    break;
                                case 5:
                                    double value2 = Double.valueOf(temp.replace("%",""));
                                    chipYield.setYield(value2);
                                    break;
                                default:
                                    break;
                            }
                        }else{
                            continue;
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            chipYieldList.add(chipYield);
        }
        return chipYieldList;
    }
    /**
     *
     * @param cell
     * @return
     */
    public Object getCellVal(Cell cell){
        Object obj = null;
        switch (cell.getCellType()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return obj;
    }
}
