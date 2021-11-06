<?php

    class Funcionario {
        private $codFuncionario;
        private $loginFuncionario;
        private $senha;
    
        public function setCodFuncionario($cod) {
            $this -> codFuncionario = $cod;
        }

        public function getCodFuncionario() {
            return $this -> codFuncionario;
        }

        public function setLoginFuncionario($login) {
            $this -> loginFuncionario = $login;
        }

        public function getLogin() {
            return $this -> loginFuncionario;
        }

        
        public function setSenha($senha) {
            $this -> senha = $senha;
        }

        public function getSenha() {
            return $this -> senha;
        }
    }
?>
