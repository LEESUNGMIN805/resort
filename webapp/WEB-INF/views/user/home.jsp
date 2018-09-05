<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>User</title>
</head>
<body>
<p> user : ${user.username} </p>
</body>
</html>





<script type="text/javascript">
//<![CDATA[
 
    function goWrite() {
        var form = document.getElementById("writeForm");
        form.submit();
    }
   
    function goView(articleNo) {
        var form = document.getElementById("viewForm");
        form.articleNo.value = articleNo;
        form.submit();
       
    }
//]]>
</script>



<div id="form-group" style="display: none;">
 
    <form id="writeForm" action="./write" method="get">
    <p>
        <input type="hidden" name="boardCd" value="${boardCd }" />
    </p>
    </form>
    <form id="viewForm" action="./view" method="get">
    <p>
        <input type="hidden" name="articleNo" />
        <input type="hidden" name="boardCd" value="${boardCd }" />
    </p>
    </form>
</div>



    @RequestMapping(value="view", method=RequestMethod.GET)
    public String view(int articleNo, String boardCd, Model model){
       
        boardService.increaseHit(articleNo);
       
        //상세보기
        Article thisArticle = boardService.getArticle(articleNo);
 
        ArrayList<Article> list = boardService.getArticleList(boardCd);
        String boardNm = boardService.getBoardNm(boardCd);
       
        model.addAttribute("thisArticle", thisArticle);

        model.addAttribute("list", list);
        model.addAttribute("boardNm", boardNm);
        model.addAttribute("boardCd", boardCd);
       
        return "bbs/view";
    }
