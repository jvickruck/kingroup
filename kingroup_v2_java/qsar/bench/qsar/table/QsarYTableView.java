package qsar.bench.qsar.table;
import pattern.mvc.MVCTableView;

import javax.iox.table.Table;
import javax.swing.*;
import javax.swingx.tablex.ReadOnlyTableModel;
import javax.textx.FractionDigitsModel;
import javax.utilx.arrays.StrMtrx;
import javax.utilx.arrays.StrVec;

/**
 * Copyright: www.DmitryKonovalov.org, jc138691, 9/03/2007, 16:52:19
 */
public class QsarYTableView extends MVCTableView {
  private static String EMPTY = " ";
  private final Table table;
  private FractionDigitsModel formater;
  private static final int N_EXTRA_COLS = 3;

  public QsarYTableView(String name, double[] yp, Table T, FractionDigitsModel formater) {
    table = T;
    this.formater = formater;

    JTable t = makeTableView(yp, name);
    assemble(t);
  }
  private JTable makeTableView(double[] yp, String name) {
    int nRows = table.getNumRows();
    int nColsZ = table.getNumCols();
    int nCols = N_EXTRA_COLS + nColsZ;
    String[][] rowData = new String[rowToView(nRows)][nCols];
    String[] colNames = new String[nCols];
    StrMtrx.set(rowData, EMPTY);
    StrVec.set(colNames, EMPTY);
    rowData[0][0] = table.getName();
    colNames[0] = "#";
    colNames[1] = table.getName();
    colNames[2] = name;
    rowData[0][0] = colNames[0];
    rowData[0][1] = colNames[1];
    rowData[0][2] = colNames[2];
    for (int r = 0; r < nRows; r++) {
      rowData[rowToView(r)][0] = Integer.toString(r+1);
      rowData[rowToView(r)][1] = table.getRowId(r);
      rowData[rowToView(r)][2] = formater.format(yp[r]);

      for (int c = 0; c < nColsZ; c++) {
        if (r == 0) {
          colNames[c + N_EXTRA_COLS] = table.getColId(c);
          rowData[0][c + N_EXTRA_COLS] = colNames[c + N_EXTRA_COLS];
        }
        rowData[rowToView(r)][c + N_EXTRA_COLS] = formater.format(table.get(r, c));
      }
    }
    return new JTable(new ReadOnlyTableModel(rowData, colNames));
  }

  private int rowToView(int r)
  {
    return r + 1;
  }

  public Table getTable() {
    return table;
  }
}

