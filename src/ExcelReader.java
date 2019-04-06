import model.Hotel;
import model.Room;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {


    public static List<Hotel> listLoader() throws IOException {
        Workbook workbook = WorkbookFactory.create(new File("C:/Users/David/Desktop/Hotel-Test.xlsx"));
        List<Hotel> hotelList = new ArrayList<>();

        Sheet sheet = workbook.getSheetAt(0);
        for (int rn = 1; rn <= sheet.getLastRowNum(); rn++) {
            Row row = sheet.getRow(rn);
            hotelList.add(new Hotel(row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(),
                    row.getCell(3).getStringCellValue(),
                    (int) row.getCell(4).getNumericCellValue()));
        }

        Sheet sheet1 = workbook.getSheetAt(1);
        for (int rn = 1; rn <= sheet1.getLastRowNum(); rn++) {
            Row row = sheet1.getRow(rn);
            Room room = new Room((long) row.getCell(0).getNumericCellValue(),
                    row.getCell(1).getNumericCellValue(),
                    row.getCell(2).getStringCellValue());

            hotelList.get((int) row.getCell(3).getNumericCellValue() - 1).addRooms(room);
        }
        workbook.close();
        return hotelList;
    }
}
