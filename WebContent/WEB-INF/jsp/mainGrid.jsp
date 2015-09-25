<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to JQGrid</title>
<script type='text/javascript' src='http://code.jquery.com/jquery-1.6.2.js'></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.js"></script>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css">
    <script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
    <script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"></script>
  <style type='text/css'>
  </style>

<script type="text/javascript">
var row_selected;

$(document).ready(function(){
        $("#list").jqGrid({
            datatype: 'json',
            mtype: 'GET',
            height: 'auto',
            url:'/NdSpringWeb9/listpage',
            editurl:'/NdSpringWeb9/edit',
            colNames:['User ID','First Name','Last Name','User Name','Password'],
               colModel:[
                   {name:'userid',index:'userid', width:50, editable:true, editrules:{required:true,number:true,maxValue:200}, editoptions:{size:10}, formoptions:{elmprefix:'*'}},
                   {name:'firstname',index:'firstname', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}, formoptions:{elmprefix:'*'}},
                   {name:'lastname',index:'lastname', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}, formoptions:{elmprefix:'*'}},
                   {name:'username',index:'username', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}, formoptions:{elmprefix:'*'}},
                   {name:'password',index:'password', width:70, editable:true, editrules:{required:true}, editoptions:{size:10}, formoptions:{elmprefix:'*'}},
               ],
            gridview: true,
            toolbar: [false, "bottom"],
            pager: $('#pager'),
            rowNum:3,
            rowList:[1,2,3],
            sortname: 'userid',
            sortorder: "ASC",
            viewrecords: true,
            altRows: false,
            jsonReader : {
                root: "rows",
                page: "page",
                total: "total",
                records: "records", 
                repeatitems: false,
               },       
            imgpath: 'themes/basic/images',
            caption: 'My JQGrid App',
            onSelectRow: function(row_id){
                            if(row_id != null) {
                                row_selected = row_id;
                                }
                            }
    }); 

    $("#list").jqGrid('navGrid','#pager',{edit:true,add:true,del:true,search:false,refresh:false},
            {
              beforeShowForm: function(form) {$('#tr_userid',form).hide();}
            },
            {
             beforeShowForm: function(form) {$('#tr_userid',form).show();}
            },
            {
            }
            );
});

$.jgrid.edit = {
    addCaption: "Add User",
    editCaption: "Edit User",
    bSubmit: "Submit",
    bCancel: "Cancel",
    bClose: "Close",
    bYes : "Yes",
    bNo : "No",
    bExit : "Cancel",
    closeAfterAdd:true,
    closeAfterEdit:true,
    reloadAfterSubmit:true,
    msg: {
            required: "is mandatory or required",
            number: "is a number field. Enter a valid number",
            minValue: "should not be less than ",
            maxValue: "should not be more than "
            },
    errorTextFormat: function (response) {
        if (response.status != 200) {
            return "Error encountered while processing. Please check the accuracy of data entered.";
        }
    },
   
    afterSubmit : function(response,postdata) {
                        return(true,"ok");
                        }
};

$.jgrid.del = {
    caption: "Delete User",
    msg: "Delete selected User?",
    bSubmit: "Delete",
    bCancel: "Cancel",
    reloadAfterSubmit:true,
    closeOnEscape:true,
    onclickSubmit : function(eparams) {
                            var rowData = $("#list").jqGrid('getRowData', row_selected);
                            var retarr = {'userid':rowData['userid']};
                            return retarr;
                            }
};
</script>

<body>
<table id="list" class="scroll"></table>
<div id="pager" class="scroll" style="text-align:center;"></div>
</body>
</html>