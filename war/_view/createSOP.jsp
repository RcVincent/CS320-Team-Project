<!--  &lt;%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %&gt;
 &lt;%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %&gt; 

 This is a paragraph that was showing on the website so i removed it
from view with by commenting it out-->
<h2 style="text-align: center;"><span style="text-decoration: underline;">Create SOP</span></h2>
<h4>SOP ID Number: <input name="sopIDNumber" type="text" /></h4>
<h4>SOP Title: <input name="sopName" type="text" /></h4>
<h4>Author of SOP: <input name="sopAuthor" type="text" /></h4>
<h4>Author ID Number: <input name="authorIDnumber" type="text" /></h4>
<h4>Priority (1-10): <input name="priority" type="text" /><br /> Revision Number : 1</h4>
<h4>Select Files Associated with SOP: <input multiple="multiple" name="files" type="file" /> <input type="submit" /></h4>