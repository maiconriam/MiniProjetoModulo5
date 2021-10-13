<?php

    class Agendamento {
        private $codAgendamento;
        private $codFuncionario;
        private $codUsuario;
        private $nomeCliente;
        private $data;
        private $confirma;

        public function setCodAgendamento($cod) {
            $this -> codAgendamento = $cod;
        }

        public function getCodAgendamento() {
            return $this -> codAgendamento;        
        }

        public function setNomeCliente($nome) {
            $this -> nomeCliente = $nome;
        }

        public function getNomeCliente() {
            return $this -> nomeCliente;        
        }

        public function setData($date) {
            $this -> data = $date;
        }

        public function getData() {
            return $this -> data;        
        }

        public function setConfirma($confimacao) {
            $this -> confirma = $confimacao;
        }

        public function getConfirma() {
            return $this -> confirma;        
        }
    }
?>