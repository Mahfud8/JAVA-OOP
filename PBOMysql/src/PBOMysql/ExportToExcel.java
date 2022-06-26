/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PBOMysql;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author mmahf
 */
public class ExportToExcel {
    public ExportToExcel(JTable table, File file) { 
        try {
            TableModel tableModel = table.getModel();
            try (FileWriter fOut = new FileWriter(file)) {
                for (int i = 0; i < tableModel.getColumnCount(); i++) {
                    fOut.write(tableModel.getColumnName(i) + "\t");
                }
                fOut.write("\n");
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    for (int j = 0; j < tableModel.getColumnCount(); j++){
                        fOut.write(tableModel.getValueAt(i, j).toString() + "\t");
                    }
                    fOut.write("\n");
                }
            }
            
        } catch (IOException ex) {
            System.out.println(ex);
        } 
    }
}
