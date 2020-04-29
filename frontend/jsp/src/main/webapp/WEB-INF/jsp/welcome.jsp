<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<style>
   body{
    background-image: url("img/bg.jpg"); /* Цвет фона веб-страницы */
   }
   h2 {
    color: RGB(20, 24, 24);
   }
   p {

    color: RGB(24, 24, 24); /* Цвет текста */
   }
  </style>
<div  style="background-color:#E8E8E8  !important" class="jumbotron">
      <div class="container">
        <h2>Welcome to PixelCatShop!</h2>
        <p>This is a template for a simple marketing or informational website.
        It includes a large callout called a jumbotron and three supporting pieces
        of content. Use it as a starting point to create something more unique.</p>
        <p><a class="btn btn-success" href="/list-todos" role="button">Add Totos &raquo;</a></p>
      </div>
    </div>


</img src="${pageContext.servletContext.contextPath}/img/cattype1/redpixelcat1.png" alt="df" >
</img src="${pageContext.servletContext.contextPath}/img/cattype2/monopixelcat2.png" alt="df" >
</img src="${pageContext.servletContext.contextPath}/img/cattype1/greenpixelcat1.png" alt="df" >
</img src="${pageContext.servletContext.contextPath}/img/cattype2/redpixelcat2.png" alt="df" >
</img src="${pageContext.servletContext.contextPath}/img/cattype1/monopixelcat1.png" alt="df" >
</img src="${pageContext.servletContext.contextPath}/img/cattype2/greenpixelcat2.png" alt="df" >



<div class="container">
	Welcome ${name}!! <a href="/list-todos">Click here</a> to manage your
	todo's.
</div>


<%@ include file="common/footer.jspf"%>