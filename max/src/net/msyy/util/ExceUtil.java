package net.msyy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExceUtil {

	private static HSSFWorkbook readFile(String file) throws FileNotFoundException, IOException {
		return new HSSFWorkbook(new FileInputStream(file));
	}
	
	public static List readExcel(String path) throws Exception {
		List<Object[]> dict = new LinkedList<Object[]>();
		HSSFWorkbook workbook = readFile(path);
		for(int i = 0;i < workbook.getNumberOfSheets();i++) {//遍历工作表
			HSSFSheet sheet = workbook.getSheetAt(i);//获取sheet对象
			for(int j = 1;j < sheet.getPhysicalNumberOfRows();j++) {//遍历工作表中的行,从第一行开始
				HSSFRow row = sheet.getRow(j);//获取行
				Object[] arr = new Object[row.getPhysicalNumberOfCells()];;
				for(int k = 0;k < row.getPhysicalNumberOfCells();k++) {//遍历每行的列
					String value = "";
					HSSFCell cell = row.getCell(k);
					switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
						default:
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							value = cell.getStringCellValue();
							break;
					}
					arr[k] = value;
				}
				dict.add(arr);
			}
		}
		FileOutputStream fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
		fileOut.close();
		return dict;
	}
	
	public static void deleteFile(String dir,String type) {
		File dirPath = new File(dir);
		if(!dirPath.isDirectory()){
			System.err.println("删除失败，请选择目录或这文件夹！");
		}else{
			File[] files = dirPath.listFiles();
			for(File file: files) {
				if(file.isFile() && file.getName().lastIndexOf(type) != -1) {
					System.out.println("删除文件：" + file.getName());
					file.delete();
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		List list = readExcel("D:\\javacode\\HBUT\\data.xls");
		System.out.println(list.size());
	}

}
