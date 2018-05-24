
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SquarePanel extends JPanel {

    private int row, column;
    private GUI cg;
    private JLabel imageLabel;

    private static Image pieceImage[][] = new Image[2][6];
    private static String imageFilename[][] = {
        {"wp.png", "wn.png", "wb.png", "wr.png", "wq.png", "wk.png"},
        {"bp.png", "bn.png", "bb.png", "br.png", "bq.png", "bk.png"}};

    public SquarePanel(int x, int y, GUI c) {
        row = x;
        column = y;
        cg = c;
        setPreferredSize(new Dimension(55, 55));
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(32, 32));
        add(imageLabel);
        //loadPieceImages();
        addMouseListener(new SquareMouseListener());
    }

    public static void loadPieceImages() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                pieceImage[i][j] = Toolkit.getDefaultToolkit().getImage("images/" + imageFilename[i][j]);
            }
        }
    }

    public void setBackColor(int color) {
        if (color == 0) {
            setBackground(Color.white);
        } else {
            setBackground(Color.gray);
        }
    }

    public void setPiece(int color, int type) {
        imageLabel.setIcon(new ImageIcon(pieceImage[color][type]));
    }
    
    public void setPiece(Icon imagem) {
        imageLabel.setIcon(imagem);
    }
    
    public Icon getPiece() {
        return imageLabel.getIcon();
    }

    public void removePiece() {
        imageLabel.setIcon(null);
    }
    
    public void setBorder() {
        cg.selected(row, column);
        setBorder(BorderFactory.createLineBorder(Color.RED, 4));
    }
    
    public void removeBorder() {
        setBorder(null);
    }

    class SquareMouseListener extends MouseAdapter {

        public void mouseEntered(MouseEvent e) {
            if(getBorder() == null)
                setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
            //repaint();
        }

        public void mouseExited(MouseEvent e) {
            if (getBorder() != null && ((LineBorder)getBorder()).getLineColor() != Color.RED) {
                setBorder(null);
            }
            //repaint();
        }

        public void mousePressed(MouseEvent e) {
            cg.selected(row, column);
            if(getPiece() != null)
                setBorder(BorderFactory.createLineBorder(Color.RED, 4));
        }

    }

}
