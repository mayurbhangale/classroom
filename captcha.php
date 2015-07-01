<?
session_start();
$captcha_id = substr(session_id(), 0, 15);
?>

<html><head></head><body>
<img src="//captchator.com/captcha/image/<?= $captcha_id ?>" />
<br />
Please enter the text from the picture:
<form action="test.php" method="post">
<input type="text" name="captcha_answer" />
<input type="submit" name="submit" value="Check" />
</form>

<?
if ($_POST['captcha_answer']) {
  $answer = preg_replace('/[^a-z0-9]+/i', '', $_POST['captcha_answer']);
  if (implode(file("http://captchator.com/captcha/check_answer/".$captcha_id."/".$answer)) == '1') {
    echo '<div style="color: green">Answer correct!</div>';
  } else {
    echo '<div style="color: red">Wrong answer, please try again.</div>';
  }
}
?>
</body></html>
