<?php

    class Servico {
        private $codServico;
        private $codFuncionario;
        private $codUsuario;
        private $nomeServico;
        private $descricaoServico;
        private $valorServico;

        public function setCodServico($cod) {
            $this -> codServico = $cod;
        }

        public function getCodServico() {
            return $this -> codServico;
        }

        public function setNomeServico($nome) {
            $this -> nomeServico = $nome;
        }

        public function getNomeServico() {
            return $this -> nomeServico;
        }

        public function setDescricaoServico($descricao) {
            $this -> descricaoServico = $descricao;
        }

        public function getDescricaoServico() {
            return $this -> descricaoServico;
        }

        public function setValorServico($valor) {
            $this -> valorServico = $valor;
        }

        public function getValorServico() {
            return $this -> valorServico;
        }
    }
?>