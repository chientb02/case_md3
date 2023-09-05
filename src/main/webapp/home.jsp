<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Basic -->
    <meta charset="UTF-8">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- Site Metas -->
    <link rel="icon" href="images/fevicon.png" type="image/gif" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>Thư viện</title>


    <!-- bootstrap core css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

    <!-- fonts style -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet" />

    <!-- font awesome style -->
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" />
    <!-- responsive style -->
    <link href="css/responsive.css" rel="stylesheet" />

</head>

<body>
<div class="hero_area">
    <!-- header section strats -->
    <header class="header_section long_section px-0">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
            <a class="navbar-brand" href="book?action=display">
          <span>
            THƯ VIỆN ONLINE
          </span>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class=""> </span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="d-flex mx-auto flex-column flex-lg-row align-items-center">
                    <ul class="navbar-nav  ">
                        <li class="nav-item active">
                            <a class="nav-link" href="home.jsp">TRANG CHỦ <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about.html"> VỀ CHÚNG TÔI </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/showBook/showBook.jsp">SÁCH MỚI</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="blog.html">Blog</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="borrowingBook?action=display">SÁCH CỦA BẠN</a>
                        </li>
                    </ul>
                </div>
                <div class="quote_btn-container">
                    <a href="account">
              <span>
                LogOut
              </span>
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </a>

                </div>
                <form class="form-inline" action="/showBookServlet?action=search" method="post">
                    <input type="text" class="form-control" id="search" name="search" placeholder="Nhập vào tên sách" required>
                    <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                </form>
            </div>
        </nav>
    </header>
    <!-- end header section -->
    <!-- slider section -->
    <section class="slider_section long_section">
        <div id="customCarousel" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="container ">
                        <div class="row">
                            <div class="col-md-5">
                                <div class="detail-box">
                                    <p>
                                        "Một cuốn sách thực sự hay nên đọc trong tuổi trẻ, rồi đọc lại khi đã trưởng thành, và một nửa lúc tuổi già, giống như một tòa nhà đẹp nên được chiêm ngưỡng trong ánh bình minh, nắng trưa và ánh trăng.”  <br>

                                    </p>
                                    <p>
                                        Furniture Needs
                                    </p>

                                </div>
                            </div>
                            <div class="col-md-7">
                                <div class="img-box" style="max-width: 1452px; max-height: 619px; min-width: auto;">
                                    <img src="https://png.pngtree.com/background/20211216/original/pngtree-library-noon-library-environment-photography-bookstore-learning-photography-map-with-map-picture-image_1518448.jpg" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="container ">
                        <div class="row">
                            <div class="col-md-5">
                                <div class="detail-box">
                                    <h2>
                                        เขาปล่อยให้คุณหลอกพ่อของเขา
                                    </h2>
                                    <p>
                                        Một nhà sư Thái Lan từng nói
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-7">
                                <div class="img-box"  style="max-width: 1452px; max-height: 619px; min-width: auto;">
                                    <img src="https://png.pngtree.com/background/20210709/original/pngtree-color-library-bookshelf-background-picture-image_911334.jpg" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <ol class="carousel-indicators">
                <li data-target="#customCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#customCarousel" data-slide-to="1"></li>
            </ol>
        </div>
    </section>
    <!-- end slider section -->
</div>

<!-- furniture section -->

<section class="furniture_section layout_padding">
    <div class="container">
        <div class="heading_container">
            <h2>
                Sách mới
            </h2>
            <p>
                "Đọc sách cho tâm trí cũng cần như thể dục cho cơ thể."
            </p>
        </div>
        <!--      sản phẩm để đây-->

        <div class="row">
        <c:forEach items="${books}" var="B">

            <div class="col-md-6 col-lg-4">
                <div class="box">
                    <div class="img-box">

                        <img src="${B.getImage()}" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            <a href="book?action=details&&id=${B.getId()}">
                                    ${B.getName()}    </a>

                        </h5>
                        <div class="price_box">
                            <h6 class="price_heading">
                                <p>Nhà xuất bản: ${B.getPublisher().getName()}</p>
                                <p>Thể loại ${B.getCategory().getName()}</p>
                                <p>Vị trí ${B.getLocation().getDetails()}</p>
                                <p>Tình trạng:${B.getDescription()}</p>
                                <p>Độ mới :${B.getStatus()}</p>
                            </h6>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>  </div>
    </div>
</section>

<!-- end furniture section -->


<!-- about section -->


<!-- end about section -->

<!-- blog section -->


<!-- end blog section -->

<!-- client section -->

<section class="client_section layout_padding-bottom">
    <div class="container">
        <div class="heading_container">
            <h2>
                Tác giả nổi bật
            </h2>
        </div>
        <div id="carouselExample2Controls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="row">
                        <div class="col-md-11 col-lg-10 mx-auto">
                            <div class="box">
                                <div class="img-box">
                                    <img src="https://scontent.fhan17-1.fna.fbcdn.net/v/t39.30808-6/356399714_3495134854061862_2371096522655077778_n.jpg?stp=cp6_dst-jpg&_nc_cat=105&ccb=1-7&_nc_sid=a2f6c7&_nc_ohc=vvre880eMTMAX_J8R3z&_nc_ht=scontent.fhan17-1.fna&oh=00_AfBZzrkG9J2NALP6ZeFQAW93DfIm9Pt09vbjn_oGkWkCdg&oe=64F5E9BC" alt="Hình ảnh người đàn ông đẹp trai nhất thế giới" />
                                </div>
                                <div class="detail-box">
                                    <div class="name">
                                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                                        <h6>
                                            Vũ Đức Chiến
                                        </h6>
                                    </div>
                                    <p>
                                        Một cây bút mới nổi với rất nhiều tài năng. Tác giả của nhiều cuốn sách nổi tiếng như "Trưa nay ăn gì" , "How are you from ?"...
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="row">
                        <div class="col-md-11 col-lg-10 mx-auto">
                            <div class="box">
                                <div class="img-box">
                                    <img src="images/client.jpg" alt="" />
                                </div>
                                <div class="detail-box">
                                    <div class="name">
                                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                                        <h6>
                                            Siaalya
                                        </h6>
                                    </div>
                                    <p>
                                        It is a long established fact that a reader will be
                                        distracted by the readable cIt is a long established fact
                                        that a reader will be distracted by the readable c
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="row">
                        <div class="col-md-11 col-lg-10 mx-auto">
                            <div class="box">
                                <div class="img-box">
                                    <img src="images/client.jpg" alt="" />
                                </div>
                                <div class="detail-box">
                                    <div class="name">
                                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                                        <h6>
                                            Siaalya
                                        </h6>
                                    </div>
                                    <p>
                                        It is a long established fact that a reader will be
                                        distracted by the readable cIt is a long established fact
                                        that a reader will be distracted by the readable c
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel_btn-container">
                <a class="carousel-control-prev" href="#carouselExample2Controls" role="button" data-slide="prev">
                    <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExample2Controls" role="button" data-slide="next">
                    <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</section>

<!-- end client section -->

<!-- contact section -->
<section class="contact_section  long_section">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="form_container">
                    <div class="heading_container">
                        <h2>
                            Liên hệ
                        </h2>
                    </div>
                    <form action="">
                        <div>
                            <input type="text" placeholder="Tên" />
                        </div>
                        <div>
                            <input type="text" placeholder="Số điện thoại" />
                        </div>
                        <div>
                            <input type="email" placeholder="Email" />
                        </div>
                        <div>
                            <input type="text" class="message-box" placeholder="Nội dung" />
                        </div>
                        <div class="btn_box">
                            <button>
                                SEND
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-6">
                <div class="map_container">
                    <div class="map">
                        <div id="googleMap"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end contact section -->

<!-- info section -->
<section class="info_section long_section">

    <div class="container">
        <div class="contact_nav">
            <a href="">
                <i class="fa fa-phone" aria-hidden="true"></i>
                <span>
           Liên hệ :012345678
          </span>
            </a>
            <a href="">
                <i class="fa fa-envelope" aria-hidden="true"></i>
                <span>
            Email : chienne@gmail.com
          </span>
            </a>
            <a href="">
                <i class="fa fa-map-marker" aria-hidden="true"></i>
                <span>
            Địa chỉ
          </span>
            </a>
        </div>

    </div>
</section>
<!-- end info_section -->


<!-- footer section -->

<!-- footer section -->


<!-- jQery -->
<script src="js/jquery-3.4.1.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.js"></script>
<!-- custom js -->
<script src="js/custom.js"></script>
<!-- Google Map -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap"></script>
<!-- End Google Map -->

</body>

</html>