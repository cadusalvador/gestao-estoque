//package br.com.projetointegrador.grupoIII.api.security.domain;
//
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import lombok.experimental.SuperBuilder;
//
//import javax.persistence.Entity;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//import static javax.persistence.EnumType.STRING;
//import static javax.persistence.GenerationType.IDENTITY;
//
//@Entity
//@SuperBuilder
//@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
//public class Permissao {
//
//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    private Integer id;
//
//    @Enumerated(STRING)
//    private Funcao funcao;
//
//    @ManyToOne
//    @JoinColumn(name = "usuario_id")
//    private Usuarios usuarios;
//}
