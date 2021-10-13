<?php

    class Funcionario {
        private $codFuncionario;
        private $nome;
        private $login;
        private $senha;
    
        public function setCodFuncionario($cod) {
            $this -> codFuncionario = $cod;
        }

        public function getCodFuncionario() {
            return $this -> codFuncionario;
        }

        public function setNome($nome) {
            $this -> nome = $nome;
        }

        public function getNome() {
            return $this -> nome;
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