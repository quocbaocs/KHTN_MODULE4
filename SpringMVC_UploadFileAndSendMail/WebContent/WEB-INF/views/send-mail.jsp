<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form method="post" class="form" action="send-mail">
	<table>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td>Subject</td>
			<td><input type="text" name="subject" /></td>
		</tr>
		<tr>
			<td>Content</td>
			<td><textarea name="content"></textarea></td>
		</tr>
		<tr align="center">
			<td>
				<button>Send mail</button>
			</td>
		</tr>
	</table>
</form>