var TT = KindEditorUtil = {	
    //格式化域名类型
    findTypeName : function(val,row){
    	var name;
    	$.ajax({
    		type : "post",
    		url : "/type/queryTypeName",
    		data : {typeId:val},
    		cache:true,    //缓存
    		async:false,    //表示同步   默认的是异步的true
    		dataType:"text",
    		success:function(data){
        		name = data;
        	}
    	});
    	return name;
    },
    //格式化标签
    findLabelName : function(val,row){
    	var name;
    	$.ajax({
    		type : "post",
    		url : "/label/queryLabelName",
    		data : {labelId:val},
    		cache:true,    //缓存
    		async:false,    //表示同步   默认的是异步的true
    		dataType:"text",
    		success:function(data){
        		name = data;
        	}
    	});
    	return name;
    	
    },
    //格式化来源
    findSourceName : function(val,row){
    	var name;
    	$.ajax({
    		type:"post",
    		url:"/source/querySourceName",
    		data:{sourceId:val},
    		cache:true,    //缓存
    		async:false,    //表示同步   默认的是异步的true
    		dataType:"text",
    		success:function(data){
        		name = data;
        	}
    		
    	});
    	return name;
    },
    //格式化名称
    findRoleName : function(val,row){
    	var name;
    	$.ajax({
    		type:"post",
    		url:"/role/queryRoleName",
    		data:{roleId:val},
    		cache:true,    //缓存
    		async:false,    //表示同步   默认的是异步的true
    		dataType:"text",
    		success:function(data){
        		name = data;
        	}
    		
    	});
    	return name;
	},
    getSelectionsIds : function (select){
    	var list = $(select);
    	var sels = list.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    },
};
