import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Game extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;
    private Player player = new Player(50, 50, Direction.DOWN);
    private Ghost ghost1 = new Ghost(0,0,Direction.UP);
    private Ghost ghost2 = new Ghost(500,0,Direction.UP);
    private Ghost ghost3 = new Ghost(0,500,Direction.UP);
    private Ghost ghost4 = new Ghost(500,500,Direction.UP);
    private Bomb bomb = new Bomb(100,100);
    private Booster booster = new Booster(400, 400, 10);

    private JLabel imgPlayer = new JLabel(new ImageIcon("src/images/pacman.png"));
    private JLabel imgGhost1 = new JLabel(new ImageIcon("src/images/ghost_1.png"));
    private JLabel imgGhost2 = new JLabel(new ImageIcon("src/images/ghost_2.png"));
    private JLabel imgGhost3 = new JLabel(new ImageIcon("src/images/ghost_3.png"));
    private JLabel imgGhost4 = new JLabel(new ImageIcon("src/images/ghost_4.png"));
    private JLabel imgBomb = new JLabel(new ImageIcon("src/images/bomb.png"));
    private JLabel imgBooster = new JLabel(new ImageIcon("src/images/booster.png"));

    private final int SCREENSIZE = 600;
    private int speed = 50;

    public static void main(String[] args) {
        new Game().init();
    }

    private void init() {
        setLayout(null);
        player.setScreenSize(SCREENSIZE);
        player.setLife(15);

        ghost1.setScreenSize(SCREENSIZE);
        ghost2.setScreenSize(SCREENSIZE);
        ghost3.setScreenSize(SCREENSIZE);
        ghost4.setScreenSize(SCREENSIZE);

        player.setX(500);
        player.setY(500);

        bomb.setScreenSize(SCREENSIZE);
        bomb.setX(100);
        bomb.setY(0);

        booster.setScreenSize(SCREENSIZE);
        booster.setX(0);
        booster.setY(100);

        add(imgPlayer);
        add(imgGhost1);
        add(imgGhost2);
        add(imgGhost3);
        add(imgGhost4);
        add(imgBomb);
        add(imgBooster);

        render();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(SCREENSIZE + 100, SCREENSIZE + 100);
        getContentPane().setBackground(new java.awt.Color(5, 5, 5));
        setVisible(true);
        addKeyListener(this);

        run();
    }

    private void render() {

        updateLocation(imgPlayer, player);
        updateLocation(imgGhost1, ghost1);
        updateLocation(imgGhost2, ghost2);
        updateLocation(imgGhost3, ghost3);
        updateLocation(imgGhost4, ghost4);
        updateLocation(imgBomb, bomb);
        updateLocation(imgBooster, booster);
        setTitle("Life: " + player.getLife());
        SwingUtilities.updateComponentTreeUI(this);

    }

    private void updateLocation(JLabel label, GameObject object) {
        label.setBounds(object.getX(), object.getY(), 50, 50);
        ImageIcon myImage = (ImageIcon) label.getIcon();
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        if(object instanceof Item){
            Item item = (Item) object;
            label.setVisible(item.isVisible());
        }
        label.setIcon( new ImageIcon(newImg) );
    }

    private void run() {
        while (player.getLife() > 0) {
            //TODO: coloque aqui os métodos de movimentação e colisão

            ghost1.move();
            ghost2.move();
            ghost3.move();
            ghost4.move();
            player.move();

            if(player.collide(bomb)){
                player.damage();
                bomb.setVisible(false);
            }
            if(player.collide(ghost1)) player.damage();

            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            render();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (c == '8' || c == 'w') player.setDirection(Direction.UP);
        if (c == '6' || c == 'd') player.setDirection(Direction.RIGHT);
        if (c == '2' || c == 's') player.setDirection(Direction.DOWN);
        if (c == '4' || c == 'a') player.setDirection(Direction.LEFT);
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}



}
