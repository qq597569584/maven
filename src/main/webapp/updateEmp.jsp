<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>update Emp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            var id = $("#id").val();
            $.ajax({
                url: "${pageContext.request.contextPath}/department/ygTianJia",
                datatype: "json",
                type: "get",
                success: function (data) {
                    $.each(data, function (index, doc) {
                        if (id == doc.id) {
                            var opt1 = $("<option>").val(doc.id).html(doc.name);
                            opt1.attr("selected", "selected");
                        } else {
                            var opt2 = $("<option>").val(doc.id).html(doc.name);
                        }
                        $("#sl").append(opt1).append(opt2);
                    })
                }

            })
        })
    </script>
</head>

<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="${pageContext.request.contextPath}/department/chaXunAll">Main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                update Emp info:
            </h1>
            <form action="${pageContext.request.contextPath}/emp/xiuGai" method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${emp.id}"/>
                <input type="hidden" id="id" value="${emp.dcid}"/>
                <input type="hidden" name="src" value="${emp.src}"/>
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            id:
                        </td>
                        <td valign="middle" align="left">
                            ${emp.id}
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            头像:
                        </td>
                        <td valign="middle" align="left">
                            <img width="40px" height="40px" src="${pageContext.request.contextPath}/pig/${emp.src}"/>
                            <input type="file" name="upload"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            姓名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" value="${emp.name}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            工资:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="salary" value="${emp.salary}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            年龄:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="age" value="${emp.age}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            部门:
                        </td>
                        <td valign="middle" align="left">
                            <select name="dcid" id="sl">

                            </select>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="修改"/>
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
