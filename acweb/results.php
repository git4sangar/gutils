<?

/* GN
You may want to use oEmbed discovery instead of hard-coding the oEmbed endpoint.
*/

$hwroll = 0;
$hwname = 'Guest';
$hwresult = 'PARTICIPATOR';
$std = 0;
$sec = 0;
$nomail = 'donotmail@email.com';
$nomobile = "0";
$dbh = 0;

class Student {
    public $roll;
    public $name;
    public $result;
    public $std;
    public $sec;
    public $school;
    public $premises;
    public $email;
    public $mobile;
}

function generateRandomString($length = 10) {
    $characters = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $randomString = '';
    for ($i = 0; $i < $length; $i++) {
        $randomString .= $characters[rand(0, strlen($characters) - 1)];
    }
    return $randomString;
}

function updatePotentialGuest($isOk) {
	try {
		$dbh 	= new PDO('mysql:dbname=hwcontest;host=localhost', 'root', '');
		//$dbh 	= new PDO('mysql:dbname=hwcontest;host=localhost', 'sangar', 'Parou123');
		$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		
		$gmobile = "";
		$isPresent = 0;
		if(!empty($_POST['mobile'])) {
			$gmobile = $_POST['mobile'];
			$sql	= "SELECT * FROM potential WHERE mobile='$gmobile'";
			$q	= $dbh->query($sql);
			if($q) {
				$row	= $q->fetch(PDO::FETCH_ASSOC);
				if($row) {
					$isPresent = 1;
				}
			}
		
			if(0 == $isPresent) {
				$sql	= "INSERT INTO potential (mobile) values ('$gmobile')";
				$dbh->exec($sql);
				
				if(!empty($_POST['email'])) {
					$gemail = $_POST['email'];
					$sql	= "UPDATE potential SET email='$gemail' WHERE mobile='$gmobile'";
					$dbh->exec($sql);
				}
				
				if(1 == $isOk) {
					$gemail = $_POST['email'];
					$sql	= "UPDATE potential SET isok=isok+1 WHERE mobile='$gmobile'";
					$dbh->exec($sql);
				}
			}
		}
		$dbh = null;
	} catch(PDOException $e) {
		echo "exception";
		$dbh = null;
	}
}

function updateDetails($roll) {
	$stud = null;
	try {
		$dbh 	= new PDO('mysql:dbname=hwcontest;host=localhost', 'root', '');
		//$dbh 	= new PDO('mysql:dbname=hwcontest;host=localhost', 'sangar', 'Parou123');
		$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

		$sql	= "SELECT * FROM master01 WHERE roll='$roll'";
		$q	= $dbh->query($sql);
		if($q) {
			$row	= $q->fetch(PDO::FETCH_ASSOC);
			if($row) {
				$stud = new Student();
				$stud->roll = $roll;
				$stud->name = $row['name'];
				$stud->result = $row['result'];
				$stud->std = $row['std'];
				$stud->sec = $row['sec'];
				$stud->school = $row['school'];
				$stud->premises = $row['premises'];
				$stud->email = $row['email'];
				$stud->mobile = $row['mobile'];
			}
		}
		
		//	Increment site visit count
		$sql	= "UPDATE master01 SET siteVisit=siteVisit+1 WHERE roll='$roll'";
		$dbh->exec($sql);
		
		//	Update email address
		if(!empty($_POST['email'])) {
			$inMail = $_POST['email'];
			$sql	= "UPDATE master01 SET email='$inMail' WHERE roll='$roll'";
			$dbh->exec($sql);
		}

		//	Update mobile number
		if(!empty($_POST['mobile'])) {
			$inMobile = $_POST['mobile'];
			$sql	= "UPDATE master01 SET mobile='$inMobile' WHERE roll='$roll'";
			$dbh->exec($sql);
		}
		$dbh = null;
	} catch(PDOException $e) {
		echo "exception";
		$dbh = null;
	}
	return $stud;
}

?>
<!DOCTYPE html>
<html lang="en">
<head>

</head>
<body>

    <?php
		if(!empty($_POST['pguest'])) {
			updatePotentialGuest(1);
			echo file_get_contents("index.html");
			return;
		}
		$stud = updateDetails($_POST['roll']);
		$studRes = " Unknown ";
		$welcomeMsg1 = "";
		$welcomeMsg2 = "";
		$welcomeMsg3 = "";
		if(null != $stud && !empty($_POST['student'])) {
			switch($stud->result) {
				case 0:
					$studRes = "You are eligible for PARTICIPATOR certificate.";
					break;
				case 1:
					$studRes = "You are a TOPPER and got selected for next level conducted by BrainOBrain & Chutti TV.";
					$welcomeMsg3 = "Note: If you had used pencil, you are requested to use PEN for next round.";
					break;
				case 2:
					$studRes = "You are a ACHIEVER and you can avail a certificate for the same.";
					break;
				case 3:
					$studRes = "You are selected as a PERFORMER. You can avail a certificate.";
					break;
			}
			$welcomeMsg1 = "Congrats $stud->name,";
			$welcomeMsg2 = "$studRes";
		} else {
			updatePotentialGuest(0);
			$welcomeMsg1 = "Dear Guest,";
		}
	?>

	<P STYLE="margin-bottom: 0cm">
			<FONT COLOR="#0000ff" SIZE=6 STYLE="font-size: 22pt">
				<I><B><? echo $welcomeMsg1; ?> <br> <? echo $welcomeMsg2; ?> </B></I>
			</FONT>
			<FONT SIZE=3 STYLE="font-size: 10pt">
				<I>
					<br>
					<? echo $welcomeMsg3; ?>
				</I>
			</FONT>
	</P>
	
	<?php
		if(null != $stud && !empty($_POST['student'])) {
			$rollno = $stud->roll;
			if(!(1 <= $rollno && 100 > $rollno)) {
				echo file_get_contents("course_details_03.html");
			}
		}
	?>
	
	<?php if(!empty($_POST['student'])) { ?>
	
	<LI><P ALIGN=LEFT STYLE="font-style: normal"><FONT FACE="URW Gothic L, sans-serif"><FONT SIZE=5><SPAN STYLE="font-variant: normal"><FONT COLOR="#804c19"><B><SPAN STYLE="background: transparent">You
	can play </SPAN></B></FONT></SPAN><SPAN STYLE="font-variant: normal"><FONT COLOR="#2300dc"><B><SPAN STYLE="background: transparent">1
	hr free of cost</SPAN></B></FONT></SPAN><SPAN STYLE="font-variant: normal"><FONT COLOR="#804c19"><SPAN STYLE="background: transparent">
	</SPAN></FONT></SPAN><SPAN STYLE="font-variant: normal"><FONT COLOR="#804c19"><B><SPAN STYLE="background: transparent">on
	</SPAN></B></FONT></SPAN><SPAN STYLE="font-variant: normal"><FONT COLOR="#dd4814"><B><SPAN STYLE="background: transparent">PS2
	/ PS3 </SPAN></B></FONT></SPAN><SPAN STYLE="font-variant: normal"><FONT COLOR="#804c19"><B><SPAN STYLE="background: transparent">game
	stations marked with</SPAN></B></FONT></SPAN><SPAN STYLE="font-variant: normal"><FONT COLOR="#dd4814"><B><SPAN STYLE="background: transparent">
	##</SPAN></B></FONT></SPAN></FONT></FONT></P>
	<LI><P ALIGN=LEFT STYLE="font-style: normal"><FONT FACE="URW Gothic L, sans-serif"><FONT SIZE=5><FONT COLOR="#804c19"><B><SPAN STYLE="background: transparent">You
	can avail </SPAN></B></FONT><SPAN STYLE="font-variant: normal"><FONT COLOR="#2300dc"><B><SPAN STYLE="background: transparent">Rs</SPAN></B></FONT></SPAN><FONT COLOR="#804c19"><SPAN STYLE="background: transparent">
	</SPAN></FONT><SPAN STYLE="font-variant: normal"><FONT COLOR="#2300dc"><B><SPAN STYLE="background: transparent">100/-
	discount</SPAN></B></FONT></SPAN><FONT COLOR="#804c19"><SPAN STYLE="background: transparent">
	</SPAN></FONT><FONT COLOR="#804c19"><B><SPAN STYLE="background: transparent">in
	</SPAN></B></FONT><SPAN STYLE="font-variant: normal"><FONT COLOR="#dd4814"><B><SPAN STYLE="background: transparent">FunBelievable</SPAN></B></FONT></SPAN><FONT COLOR="#804c19"><SPAN STYLE="background: transparent">
	</SPAN></FONT><FONT COLOR="#804c19"><B><SPAN STYLE="background: transparent">fun-city
	at Thiruvanmiyur for details scroll down</SPAN></B></FONT></FONT></FONT></P>
	
	<P ALIGN=LEFT STYLE="font-variant: normal; font-style: normal"><FONT COLOR="#355e00"><FONT FACE="URW Gothic L, sans-serif"><FONT SIZE=3><B><SPAN STYLE="background: transparent">
		Regarding certificate collection,</SPAN></B></FONT></FONT></FONT></P>
<OL START=3>
	<P ALIGN=LEFT STYLE="font-variant: normal; font-style: normal"><FONT COLOR="#804c19"><FONT FACE="URW Gothic L, sans-serif"><FONT SIZE=3><B><SPAN STYLE="background: transparent">Please
	visit our website regularly </SPAN><U><SPAN STYLE="background: transparent">for
	updates</SPAN></U><SPAN STYLE="background: transparent"> in this
	regard</SPAN></B></FONT></FONT></FONT></P>
	<P ALIGN=LEFT STYLE="font-variant: normal; font-style: normal"><FONT COLOR="#804c19"><FONT FACE="URW Gothic L, sans-serif"><FONT SIZE=3><B><SPAN STYLE="background: transparent"><U>Note</U>:
	Please bring the &quot;Student's Copy&quot; to avail all these
	benefits</SPAN></B></FONT></FONT></FONT></P>
</OL>
	<?php } ?>
	
	<?php echo file_get_contents("course_details_02.html"); ?>
	
</body>
</html>
