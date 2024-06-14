<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Hello</title></head>
<body>
<h1>Phong</h1>
<form action="/dich-vu/add" method="post">

    <div>
        <label>Ten Phong</label>
        <input type="text" name="tenPhong" value="${phongRequest.tenPhong != null ? phongRequest.tenPhong : detail.tenPhong}" ><br>
        <div><c:if test="${not empty error}">
            <span style="color: hotpink">${error["tenPhong"]}</span>
        </c:if></div>
    </div>
    <div>
        <label>So luong phong</label>
        <input type="text" name="soLuongPhong" value="${phongRequest.soLuongPhong != null ? phongRequest.soLuongPhong : detail.soLuongPhong}" ><br>
        <div><c:if test="${not empty error}">
            <span style="color: hotpink">${error["soLuongPhong"]}</span>
        </c:if></div>

    </div>
    <div>
        <label>Trang thai</label><br>
        <input type="radio" name="trangThai" value="1" <c:if test="${(phongRequest.trangThai != null ? phongRequest.trangThai : detail.trangThai) eq '1'}">checked</c:if>>Con
        phong<br>
        <input type="radio" name="trangThai" value="0" <c:if test="${((phongRequest.trangThai != null ? phongRequest.trangThai : detail.trangThai) eq '0')}">checked</c:if>>Het
        phong<br>
        <div><c:if test="${not empty error}">
            <span style="color: hotpink">${error["trangThai"]}</span>
        </c:if></div>

    </div>
    <div><label>Ghi chu</label>
        <input type="text" name="ghiChu" value="${phongRequest.ghiChu != null ? phongRequest.ghiChu : detail.ghiChu}"><br>
        <div><c:if test="${not empty error}">
            <span style="color: hotpink">${error["ghiChu"]}</span>
        </c:if></div>

    </div>

    <label>Tên loại phòng</label>
    <select name="idLoaiPhong">
        <c:forEach items="${listLoaiPhong}" var="item">
            <option value="${item.id}" <c:if test="${item.id == (phongRequest.idLoaiPhong != null ? phongRequest.idLoaiPhong : detail.id)}">selected</c:if>>${item.tenLoaiPhong}</option>
        </c:forEach>
    </select>
    <button>Add</button>
</form>
<div>
    <form action="/dich-vu/tim-kiem" method="get">
        <label>Ten Phong</label>
        <input value="${sessionScope.tenPhong}" type="text" name="tenPhong"><br>
        <label>So luong phong</label>
        <input value="${sessionScope.soLuong}" type="text" name="soLuong"><br>
        <button>Tim kiem</button>
    </form>
</div>
<table border="1">
    <thead>
    <th>Ten Phong</th>
    <th>So luong phong</th>
    <th>Trang thai</th>
    <th>Ghi chu</th>
    <th>Ten loai phong</th>
    <th>Thao tac</th>
    </thead>
    <tbody>
    <c:forEach items="${listPhong}" var="phong">
        <tr>
            <td>${phong.tenPhong}</td>
            <td>${phong.soLuongPhong}</td>
            <td>${phong.trangThai}</td>
            <td>${phong.ghiChu}</td>
            <td>${phong.tenLoaiPhong}</td>
            <td>
                <a href="/dich-vu/detail/${phong.id}">
                    <button>Detail</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>