package visao;

import javax.swing.JOptionPane;
import modelo.Emprestimo;
import dao.EmprestimoDAO;
import java.util.Date;

/**
 *
 * @author legen
 */
public class frmCadastroEmprestimo extends javax.swing.JFrame {
 
    private final Emprestimo objetoEmprestimo;
    private final EmprestimoDAO emprestimoDAO;
    /**
     * Creates new form frmCadastroEmprestimos
     */
  public frmCadastroEmprestimo (){
        initComponents();
        this.objetoEmprestimo = new Emprestimo();
        this.emprestimoDAO = new EmprestimoDAO();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JTFDataEmprestimo = new com.toedter.calendar.JDateChooser();
        JTFNomeAmigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFNomeFerramenta = new javax.swing.JTextField();
        JBCancelar2 = new javax.swing.JButton();
        JBCadastrar3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Emprestimos");
        setMinimumSize(new java.awt.Dimension(564, 367));
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data de Emprestimo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(330, 100, 180, 21);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Cadastrar Empréstimo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 20, 260, 29);
        jPanel1.add(JTFDataEmprestimo);
        JTFDataEmprestimo.setBounds(380, 120, 110, 22);
        jPanel1.add(JTFNomeAmigo);
        JTFNomeAmigo.setBounds(10, 120, 290, 22);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome: ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 90, 59, 21);
        jPanel1.add(JTFNomeFerramenta);
        JTFNomeFerramenta.setBounds(130, 170, 360, 22);

        JBCancelar2.setBackground(new java.awt.Color(255, 153, 0));
        JBCancelar2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        JBCancelar2.setForeground(new java.awt.Color(255, 255, 255));
        JBCancelar2.setText("Voltar");
        JBCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelar2ActionPerformed(evt);
            }
        });
        jPanel1.add(JBCancelar2);
        JBCancelar2.setBounds(30, 260, 110, 40);

        JBCadastrar3.setBackground(new java.awt.Color(51, 255, 0));
        JBCadastrar3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        JBCadastrar3.setForeground(new java.awt.Color(255, 255, 255));
        JBCadastrar3.setText("Cadastrar");
        JBCadastrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrar3ActionPerformed(evt);
            }
        });
        jPanel1.add(JBCadastrar3);
        JBCadastrar3.setBounds(390, 260, 110, 40);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ferramentas:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 170, 120, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 530, 310);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 550, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents
// Método para verificar se um amigo tem empréstimos abertos
    private void verificarEmprestimosAbertos(String nomeAmigo) {
        boolean temEmprestimosAbertos = this.emprestimoDAO.amigoTemEmprestimosAbertos(nomeAmigo);
        if (temEmprestimosAbertos) {
            JOptionPane.showMessageDialog(this, "O amigo " + nomeAmigo + " ainda tem itens não devolvidos.", "Empréstimos Abertos", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void JBCadastrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrar3ActionPerformed
  try {
            String nome_amigo = "";
            String nome_ferramenta = "";
            Date dataEmprestimo = null;

            if (this.JTFNomeAmigo.getText().length() < 2) {
                throw new Mensagens("Nome do amigo deve conter ao menos 2 caracteres.");
            } else {
                nome_amigo = this.JTFNomeAmigo.getText();
            }

            if (this.JTFNomeFerramenta.getText().length() < 2) {
                throw new Mensagens("Nome da ferramenta deve conter ao menos 2 caracteres.");
            } else {
                nome_ferramenta = this.JTFNomeFerramenta.getText();
            }

            if (this.JTFDataEmprestimo.getDate() == null) {
                throw new Mensagens("Selecione uma data de empréstimo válida.");
            } else {
                dataEmprestimo = this.JTFDataEmprestimo.getDate();
            }

            Emprestimo novoEmprestimo = new Emprestimo();
            novoEmprestimo.setNomeAmigo(nome_amigo);
            novoEmprestimo.setNomeFerramenta(nome_ferramenta);
            novoEmprestimo.setDataEmprestimo(dataEmprestimo);

            boolean inserido = this.emprestimoDAO.inserirEmprestimoBD(novoEmprestimo);

            if (inserido) {
                JOptionPane.showMessageDialog(null, "Empréstimo cadastrado com sucesso!");
                this.JTFNomeAmigo.setText("");
                this.JTFNomeFerramenta.setText("");
                this.JTFDataEmprestimo.setDate(null);

                // Verificar se o amigo tem empréstimos abertos
                verificarEmprestimosAbertos(nome_amigo);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar empréstimo.");
            }

            System.out.println(novoEmprestimo.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        }
   
// TODO add your handling code here:
    }//GEN-LAST:event_JBCadastrar3ActionPerformed

    private void JBCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelar2ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_JBCancelar2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadastroEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar3;
    private javax.swing.JButton JBCancelar2;
    private com.toedter.calendar.JDateChooser JTFDataEmprestimo;
    private javax.swing.JTextField JTFNomeAmigo;
    private javax.swing.JTextField JTFNomeFerramenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
