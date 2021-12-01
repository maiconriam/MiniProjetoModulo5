<?php

    class Divulgacoes {
        private $codDivulgacoes;
        private $tituloDivulgacoes;
        private $datePublicacao;
        private $localPublicacao;
    
        public function setCodDivulgacoes($cod) {
            $this -> codDivulgacoes = $cod;
        }

        public function getCodDivulgacoes() {
            return $this -> codDivulgacoes;
        }

        public function setTituloDivulgacoes($titulo) {
            $this -> tituloDivulgacoes = $titulo;
        }

        public function getTituloDivulgacoes() {
            return $this -> tituloDivulgacoes;
        }

        public function setDatePublicacao($date) {
            $this -> datePublicacao = $date;
        }

        public function getDatePublicacao() {
            return $this -> datePublicacao;
        }

        public function setLocalPublicacao($local) {
            $this -> localPublicacao = $local;
        }

        public function getLocalPublicacao() {
            return $this -> localPublicacao;
        }
    }
?>