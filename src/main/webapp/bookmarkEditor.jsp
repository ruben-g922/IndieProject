<%@include file="taglib.jsp"%>
<c:import url="head.jsp"/>

<html>
<head>
    <script src="bookmark.js"></script>
</head>
<body>

<c:import url="navbar.jsp"/>


<c:import url="sidebar.jsp"/>
<div class="col-sm p-3 min-vh-100">
    <!-- content -->
    <input class="form-control" placeholder="Title" id="bookmarkTitle" type="text" value="${object.title}" style="width: 100%; font-size: 160%;">
    <div class="d-flex p-2">
        <button type="button" class="btn btn-primary" style="margin-top: 1em;" onclick="bookmark();">Save</button>

        <div class="dropdown ms-auto" style="margin-top: 1em">
            <button class="btn btn-danger dropdown-toggle" type="button"
                    id="deleteBtn" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Delete
            </button>
            <form class="dropdown-menu p-4" action="delete" method="post" aria-labelledby="deleteBtn">
                <button type="submit" class="btn btn-danger">I'm sure</button>
            </form>
        </div>
    </div>

    <p class="text-success" id="saveText"></p>
    <hr />
    <div class="d-flex p-2">
        <input class="form-control" id="urlText" placeholder="URL" type="text" value="${object.url}">
    </div>
    <div class="form-outline w-100" style="height: 30%; display: flex;">
        <textarea class="form-control bg-light" placeholder="Description (optional)" style="resize: none" id="textInput">${object.description}</textarea>
    </div>
</div>
</div>
</div>
</body>
</html>
