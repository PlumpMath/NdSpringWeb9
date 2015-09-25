      <!--Header start-->
      <div class="logo"><a href="#"><img src="images/logo.png" alt="" /></a></div>
      <div class="user_info">
      <%HttpSession sessions = request.getSession();%>
			<table border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/ic_user.png" alt="" /></td>
                <td class="text_pad"><span>Welcome,</span><%=sessions.getAttribute("username_s") %><br/>
                <a href="${pageContext.request.contextPath}/editdetails">My Account</a></td>
                <td><a href="${pageContext.request.contextPath}/logout"><input name="" type="image" src="images/btn_logout.png" /></a></td>
              </tr>
            </table>
      </div>
      <div class="clear"></div>
      <!--Header end-->
    