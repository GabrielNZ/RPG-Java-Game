package com.gabrielnz.personagem;

import com.gabrielnz.itens.Equipamentos;
import com.gabrielnz.itens.ouro.Ouro;
import com.gabrielnz.magias.LivroMagia;
import com.gabrielnz.mecanicas.Inventario;
import com.gabrielnz.mecanicas.NivelXp;
import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.classes.Classe;

import java.util.InputMismatchException;

import static com.gabrielnz.mecanicas.Transicao.*;


public abstract class Jogador {
    private String nome;
    protected Integer vida;
    protected Integer vidaMax;
    protected Integer dano;
    protected Integer mana;
    protected Integer manaMax;
    protected Integer iniciativa;
    protected Integer ouro = 100;
    protected Integer xp = 0;
    protected Integer xpNecessario = 500;
    protected Integer nivel = 1;
    protected Inventario inventarioJogador;
    protected Equipamentos arma;
    protected Equipamentos armadura;
    protected LivroMagia livroMagia;
    protected boolean fugiu = false;
    protected boolean magiaLancada;
    protected Classe classe;
    protected boolean criticoGarantido;
    protected int danoBaseExtra = 0;
    protected int armaduraIgnoaradaValor = 0;
    protected int valorDadoExtra = 0;
    protected boolean rollExtra;
    protected boolean armaRoubada;
    protected int danoExtraRound = 0;
    protected int pontosDisponiveis = 0;


    public Jogador(String nome, Classe classe) {
        this.nome = nome;
        this.classe = classe;
        inventarioJogador = new Inventario();
    }

    public void uparDeNivel(Jogador jogador) {
        Transicao.transicao();
        jogador.setPontosDisponiveis(((jogador.getNivel() - (int) (jogador.getNivel() * 0.5)) + 1));
        NivelXp.grafic(jogador, jogador.getPontosDisponiveis());
        boolean vida = false;
        boolean dano = false;
        boolean mana = false;
        do {
            try {
                if (!vida) {
                    System.out.print("Adicionar quantos pontos em Vida (❤️)? ");
                    int pontosGastosVida = ler.nextInt();
                    if (pontosGastosVida <= jogador.getPontosDisponiveis()) {
                        jogador.uparVida(pontosGastosVida);
                        jogador.setPontosDisponiveis(jogador.getPontosDisponiveis() - pontosGastosVida);
                        vida = true;
                    } else {
                        System.out.println("Pontos invalidos...");
                        Transicao.transicao();
                        continue;
                    }
                }
                transicaolinha();
                NivelXp.grafic(jogador, jogador.getPontosDisponiveis());
                if (!dano) {
                    System.out.print("Adicionar quantos pontos em Dano (⚔️)? ");
                    int pontosGastosDano = ler.nextInt();
                    if (pontosGastosDano <= jogador.getPontosDisponiveis()) {
                        jogador.uparDano(pontosGastosDano);
                        jogador.setPontosDisponiveis(jogador.getPontosDisponiveis() - pontosGastosDano);
                        dano = true;
                    } else {
                        System.out.println("Pontos invalidos...");
                        Transicao.transicao();
                        continue;
                    }
                }
                transicaolinha();
                NivelXp.grafic(jogador, jogador.getPontosDisponiveis());
                if (!mana) {
                    System.out.print("Adicionar quantos pontos em Mana (🔮)? ");
                    int pontosGastosMana = ler.nextInt();
                    if (pontosGastosMana <= jogador.getPontosDisponiveis()) {
                        jogador.uparMana(pontosGastosMana);
                        jogador.setPontosDisponiveis(jogador.getPontosDisponiveis() - pontosGastosMana);
                        mana = true;
                    } else {
                        System.out.println("Pontos invalidos...");
                        Transicao.transicao();
                        continue;
                    }
                }
                transicaolinha();
                NivelXp.grafic(jogador, jogador.getPontosDisponiveis());
                transicao();
            } catch (InputMismatchException e) {
                System.out.println("Digite um numero!");
                Transicao.transicao();
                continue;
            }
            if (vida && dano && mana) {
                break;
            }
        } while (true);
    }

    public void adicionarOuro(Ouro ouro, Jogador jogador) {
        jogador.setOuro(jogador.getOuro() + ouro.getValor());
        System.out.println("╔═══════════════════════════════════╗");
        System.out.printf("║     💰  OURO ADICIONADO!  💰     ║%n");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.printf("║ Ouro: %-3dG                        ║%n", ouro.getValor());
        System.out.println("╚═══════════════════════════════════╝");
    }

    public void adicionarOuro(int ouro, Jogador jogador) {
        jogador.setOuro(jogador.getOuro() + ouro);
        System.out.println("╔═══════════════════════════════════╗");
        System.out.printf("║     💰  OURO ADICIONADO!  💰     ║%n");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.printf("║ Ouro: %-3dG                        ║%n", ouro);
        System.out.println("╚═══════════════════════════════════╝");
    }

    public void recuperarStatus(Jogador jogador) {
        jogador.setVida(jogador.getVidaMax());
        jogador.setMana(jogador.getManaMax());
    }

    public int getDanoExtraRound() {
        return danoExtraRound;
    }

    public void setDanoExtraRound(int dadoExtraRound) {
        this.danoExtraRound = dadoExtraRound;
    }

    public void uparVida(int pontosGastosVida) {
        this.setVidaMax(this.getVidaMax() + pontosGastosVida);
    }

    public void uparDano(int pontosGastosDano) {
        this.setDano(this.getDano() + pontosGastosDano);
    }

    public int getPontosDisponiveis() {
        return pontosDisponiveis;
    }

    public void setPontosDisponiveis(int pontosDisponiveis) {
        this.pontosDisponiveis = pontosDisponiveis;
    }

    public void uparMana(int pontosGastosMana) {
        this.setManaMax(this.getManaMax() + pontosGastosMana);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isArmaRoubada() {
        return armaRoubada;
    }

    public void setArmaRoubada(boolean armaRoubada) {
        this.armaRoubada = armaRoubada;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
        if (this.vida > this.vidaMax) {
            this.vida = vidaMax;
        }
    }

    public Integer getDano() {
        return dano;
    }

    public void setDano(Integer dano) {
        this.dano = dano;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(Integer iniciativa) {
        this.iniciativa = iniciativa;
    }

    public Integer getOuro() {
        return ouro;
    }

    public void setOuro(Integer ouro) {
        this.ouro = ouro;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Inventario getInventarioJogador() {
        return inventarioJogador;
    }

    public void setInventarioJogador(Inventario inventarioJogador) {
        this.inventarioJogador = inventarioJogador;
    }

    public Equipamentos getArma() {
        return arma;
    }

    public void setArma(Equipamentos arma) {
        this.arma = arma;
    }

    public Equipamentos getArmadura() {
        return armadura;
    }

    public void setArmadura(Equipamentos armadura) {
        this.armadura = armadura;
    }

    public boolean isFugiu() {
        return fugiu;
    }

    public void setFugiu(boolean fugiu) {
        this.fugiu = fugiu;
    }

    public Integer getXpNecessario() {
        return xpNecessario;
    }

    public void setXpNecessario(Integer xpNecessario) {
        this.xpNecessario = xpNecessario;
    }

    public Integer getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(Integer vidaMax) {
        this.vidaMax = vidaMax;
    }

    public Integer getManaMax() {
        return manaMax;
    }

    public void setManaMax(Integer manaMax) {
        this.manaMax = manaMax;
    }

    public LivroMagia getLivroMagia() {
        return livroMagia;
    }

    public void setLivroMagia(LivroMagia livroMagia) {
        this.livroMagia = livroMagia;
    }

    public boolean isMagiaLancada() {
        return magiaLancada;
    }

    public void setMagiaLancada(boolean magiaLancada) {
        this.magiaLancada = magiaLancada;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public boolean isCriticoGarantido() {
        return criticoGarantido;
    }

    public void setCriticoGarantido(boolean criticoGarantido) {
        this.criticoGarantido = criticoGarantido;
    }

    public int getDanoBaseExtra() {
        return danoBaseExtra;
    }

    public void setDanoBaseExtra(int danoBaseExtra) {
        this.danoBaseExtra = danoBaseExtra;
    }

    public int getArmaduraIgnoaradaValor() {
        return armaduraIgnoaradaValor;
    }

    public void setArmaduraIgnoaradaValor(int armaduraIgnoaradaValor) {
        this.armaduraIgnoaradaValor = armaduraIgnoaradaValor;
    }

    public int getValorDadoExtra() {
        return valorDadoExtra;
    }

    public void setValorDadoExtra(int valorDadoExtra) {
        this.valorDadoExtra = valorDadoExtra;
    }

    public boolean isRollExtra() {
        return rollExtra;
    }

    public void setRollExtra(boolean rollExtra) {
        this.rollExtra = rollExtra;
    }
}
