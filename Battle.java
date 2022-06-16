import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the actual first level that the player battles in.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Battle extends World
{
    public Pikachu p = new Pikachu();
    public Charmander c = new Charmander();
    public Bulbasaur b = new Bulbasaur();
    public Eevee e = new Eevee();
    public Rowlet r = new Rowlet();
    public Fennekin f = new Fennekin();
    public Torchic t = new Torchic();
    public Ninetales n = new Ninetales();
    public static int  count = 1;
    public int bX = 0;
    public int bY;
    public int bZ;
    public int tX;
    public int tY;
    public int tZ;
    public int pX;
    public int pY;
    public int pZ;
    public int cX = 0;
    public int cY;
    public int cZ;
    public int hp1;
    public int hp2;
    public int hp3;
    public int hp4;
    public Label fail = new Label("you failed:(, restart", 50); 
    private SimpleTimer timer = new SimpleTimer();
    private SimpleTimer timer1 = new SimpleTimer();
    
    public Battle()
    {    
        super(900, 506, 1, false); 
        
        GeneralInformation g = new GeneralInformation();
        
        if(count == 1)
        {
            setBackground(new GreenfootImage("1.png"));
        
            addObject(p, 250, 400);
        
            addObject(c, 350, 400);
        
            addObject(e, 250, 150);
        }
        else if(count == 2)
        {
            Pikachu.pHP = 65;
            Charmander.cHP = 65;
            Bulbasaur.bHP = 50;
            setBackground(new GreenfootImage("7.png"));
            if(GeneralInformation.character[0].equals("Pikachu"))
            {
                addObject(p, 250, 400);
            }
            if(GeneralInformation.character[0].equals("Bulbasaur"))
            {
                addObject(b, 250, 400);
            }
            if(GeneralInformation.character[1].equals("Charmander"))
            {
                addObject(c, 350, 400);
            }
            if(GeneralInformation.character[1].equals("Eevee"))
            {
                addObject(e, 350, 400);
            }
            
            addObject(f, 250, 150); 
        }
        else if(count == 3)
        {
            Pikachu.pHP = 65;
            Charmander.cHP = 65;
            Bulbasaur.bHP = 50;
            Torchic.tHP = 45;
            setBackground(new GreenfootImage("9.png"));
        
            if(GeneralInformation.character[0].equals("Pikachu"))
            {
                addObject(p, 250, 350);
            }
            if(GeneralInformation.character[1].equals("Charmander"))
            {
                addObject(c, 250, 350);
            }
            if(GeneralInformation.character[0].equals("Bulbasaur"))
            {
                addObject(b, 250, 350);
            }
            if(GeneralInformation.character[1].equals("Torchic"))
            {
                addObject(t, 250, 350);
            }
            
            addObject(n, 200, 150);
        }
    }
    
    public void act()
    {
        if(count == 1)
        {
            if(e.eHP > 0)
            {
                attack3(e.getX(), e.getY(), new GreenfootImage("plantAtt.png"));
            }
            if(e.eHP <= 0)
            {
                setBackground(new GreenfootImage("2.png"));
                removeObject(e);
                addObject(r, 750, 100);
                if(r.rHP > 0)
                {
                    attack3(r.getX(), r.getY(), new GreenfootImage("plantAtt.png"));
                }
            }
            if(r.rHP <= 0)
            {
                setBackground(new GreenfootImage("3.png"));
                removeObject(r);
                addObject(b, 150, 100);
                if(b.bHP > 0)
                {
                    attack3(b.getX(), b.getY(), new GreenfootImage("plantAtt.png"));
                }
            }
            if(b.bHP <= 0)
            {
                removeObject(b);
                if(p.getX() > 900 || c.getX() > 900)
                {
                    Map2 m2 = new Map2();
                    Greenfoot.setWorld(m2);
                    count++;
                }
            }
            if(p.pHP <= 0 && c.cHP <= 0)
            {
                addObject(fail, 640, 360);
                Store1 s1 = new Store1();
                Greenfoot.setWorld(s1);
            }
        }
        else if(count == 2)
        {
            if(f.fHP > 0)
            {
                attack3(f.getX(), f.getY(),  new GreenfootImage("fireAtt.png"));
            }
            if(f.fHP <= 0)
            {
                setBackground(new GreenfootImage("8.png"));
                removeObject(f);
                addObject(t, 750, 100);
                if(t.tHP > 0)
                {
                    attack3(t.getX(), t.getY(),  new GreenfootImage("fireAtt.png"));
                }
            }
            if(t.tHP <= 0)
            {
                
                removeObject(t);
                if(p.pikachuX > 900 || cX > 900 || bX > 900)
                {
                    Map3 s3 = new Map3();
                    Greenfoot.setWorld(s3);
                    count++;
                }
            }
            if(GeneralInformation.character[0].equals("Pikachu"))
            {
                hp1 = p.pHP;
            }
            if(GeneralInformation.character[0].equals("Bulbasaur"))
            {
                hp1 = b.bHP;
            }
            if(GeneralInformation.character[1].equals("Charmander"))
            {
                hp2 = c.cHP;
            }
            if(hp1 <= 0 && hp2 <= 0)
            {
                Map2 m2 = new Map2();
                Greenfoot.setWorld(m2);
            }
            
        }
        else if(count == 3)
        {
            if(n.nHP > 0)
            {
                attack3(n.getX(), n.getY(),  new GreenfootImage("fireAtt.png"));
            }
            if(GeneralInformation.character[0].equals("Pikachu"))
            {
                hp1 = p.pHP;
            }
            if(GeneralInformation.character[0].equals("Bulbasaur"))
            {
                hp1 = b.bHP;
            }
            if(GeneralInformation.character[1].equals("Charmander"))
            {
                hp2 = c.cHP;
            }
            if(GeneralInformation.character[1].equals("Torchic"))
            {
                hp2 = t.tHP;
            }
            if(n.nHP <= 0)
            {
                removeObject(n);
            }
        }
        
        if(GeneralInformation.character[0].equals("Pikachu"))
        {
            pX = p.getX();
            pY = p.getY();
            pZ = p.getRotation();
            attack1(pX, pY, pZ, Pikachu.damage, new GreenfootImage("pikachuatt.png"));
        }
        if(GeneralInformation.character[1].equals("Charmander"))
        {
            cX = c.getX();
            cY = c.getY();
            cZ = c.getRotation();
            attack2(cX, cY, cZ, Charmander.damage, new GreenfootImage("fireAtt.png"));
        }
        if(GeneralInformation.character[0].equals("Bulbasaur"))
        {
            bX = b.getX();
            bY = b.getY();
            bZ = b.getRotation();
            if(Bulbasaur.enemy != true)
            {
                attack1(bX, bY, bZ, Bulbasaur.damage, new GreenfootImage("plantAtt.png"));
            }
        }
        if(GeneralInformation.character[1].equals("Torchic"))
        {
            tX = t.getX();
            tY = t.getY();
            tZ = t.getRotation();
            if(Torchic.enemy != true)
            {
                attack2(tX, tY, tZ, Torchic.damage, new GreenfootImage("fireAtt.png"));
            }
        }
    }  
    
    
    
    public void attack1(int x, int y, int z, int damage, GreenfootImage image)
    {
        if(Greenfoot.isKeyDown("space"))
        {
            if(timer.millisElapsed() > 500)
            {
                NormalAttack a = new NormalAttack(image, damage);
                addObject(a,x,y);
                a.setRotation(z);
                timer.mark();
                
            }
        }
    }
    
    public void attack2(int x, int y, int z, int damage, GreenfootImage image)
    {
        if(Greenfoot.isKeyDown("r"))
        {
            if(timer.millisElapsed() > 500)
            {
                NormalAttack a = new NormalAttack(image, damage);
                addObject(a,x,y);
                a.setRotation(z);
                timer.mark();
                
            }
        }
    }
    
    
    public void attack3(int x, int y, GreenfootImage image)
    {
        if(timer1.millisElapsed() > 2000)
        {
            for(int i = 1; i < 9; i++)
            {
                EnemyAttack e = new EnemyAttack(image);
                addObject(e,x,y);
                e.setRotation(i * 45);
                timer1.mark();
            }
            
        }
    }
}
