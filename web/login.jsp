<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <!-- Bootstrap core CSS -->
        <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="LoginStyle.css" rel="stylesheet">

        <script src="../../assets/js/ie-emulation-modes-warning.js"></script>


        <title>Dell sign in page</title>
    </head>
    <body>
        <div id="header">
            <h1>Welcome to Dell login page</h1>
            <img src="dell round logo.png" width="150" height="150" alt="dell round logo"/>          
        </div>

        <div class="container">

            <form class="form-signin" action="Control" method="POST">
                <h3 class="form-signin-heading">Please sign in</h3>
                <label for="inputUsername" class="sr-only">Username</label>
                <input type="text" name="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="origin" value="login">Login</button>
            </form>
            <div id="bottom">

            </div>
            <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
