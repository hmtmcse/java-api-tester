package com.hmtmcse.apitester;

import com.hmtmcse.console.table.common.TableConstant;
import com.hmtmcse.console.table.data.Table;
import com.hmtmcse.console.table.data.TableRowData;

public class ATReport {

    public static Table start(){
        Table table = new Table();
        table.addHeader("Success", TableConstant.LEFT_ALIGN, TableConstant.YALLOW);
        table.addHeader("Name", TableConstant.LEFT_ALIGN, TableConstant.YALLOW);
        table.addHeader("URL", TableConstant.LEFT_ALIGN, TableConstant.YALLOW);
        table.addHeader("Method", TableConstant.LEFT_ALIGN, TableConstant.YALLOW);
        table.addHeader("Request Type", TableConstant.LEFT_ALIGN, TableConstant.YALLOW);
        return table;
    }

    public static TableRowData isSuccess(Boolean isSuccess, TableRowData rowData){
        if (isSuccess){
            rowData.add("YES");
        }else {
            rowData.add("NO", TableConstant.LEFT_ALIGN, TableConstant.RED);
        }
        return rowData;
    }

}
