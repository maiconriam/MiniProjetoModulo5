<?php

    include("Email/class.phpmailer.php");


    function email ($para_email, $para_nome, $assunto, $html){

        $mail2 = new PHPMailer;
        $mail2->IsSMTP();
        
        $mail2->From = "suporte@fbservicos.com";
        $mail2->FromName = "Anderson Bastos";


        $mail2->Host =              "smtp.fbservicos.com";
        $mail2->Port =              587;
        $mail2->SMTPAuth =          "true";
        $mail2->Username =          "suporte@fbservicos.com";
        $mail2->Password =          "R0ch@1979!!";

        $mail2->AddAddress($para_email, $para_nome);

        $mail2->Subject = "$assunto";
        $mail2->MsgHTML($html);
        if($mail2->Send()){
            return "1";
        }else{
            return $mail2->ErrorInfo;
        }
    }


    $corpo_email = "<html><body>Olá eu estou testando o meu php para enviar emails</body></html>";

    $retorno =  email("andersonrochabastos@gmail.com", "Anderson Rochc", "Vamos torcer pra dar certo", $corpo_email);

    if($retorno == 1){
        echo "<p style='color: green'>Erro: E-mail enviado com sucesso!!!</p>";
    }else{
        echo $retorno;
    }



?>