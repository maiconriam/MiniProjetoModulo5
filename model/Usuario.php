<?php

    class Usuario {
        private $codUsuario;
        private $nomeUsuario;
        private $dataNascimento;
        private $loginUsuario;
        private $senha;
       
        public function setCodUsuario($cod) {
            $this -> codUsuario = $cod;
        }

        public function getCodUsuario() {
            return $this -> codUsuario;
        }
        
         public function setNomeUsuario($nome) {
            $this -> nomeUsuario = $nome;
        }

        public function getNomeUsuario() {
            return $this -> nomeUsuario;
        }

        public function setLoginUsuario($login) {
            $this -> loginUsuario = $login;
        }

        public function getLoginUsuario() {
            return $this -> loginUsuario;
        }

        public function setSenha($senha) {
            $this -> senha = $senha;
        }

        public function getSenha() {
            return $this -> senha;
        }
    }
?>
