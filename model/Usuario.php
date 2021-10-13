<?php

    class Usuario {
        private $codUsuario;
        private $login;
        private $senha;
       
        public function setCodUsuario($cod) {
            $this -> codUsuario = $cod;
        }

        public function getCodUsuario() {
            return $this -> codUsuario;
        }

        public function setLogin($login) {
            $this -> login = $login;
        }

        public function getLogin() {
            return $this -> login;
        }

        public function setSenha($senha) {
            $this -> senha = $senha;
        }

        public function getSenha() {
            return $this -> senha;
        }
    }
?>