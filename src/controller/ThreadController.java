package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

	private int idThread;
	private Semaphore semaforo1;
	private Semaphore semaforo2;
	private int manobra;
	private int taxiar;
	private int decolagem;
	private int afastamento;
	private int decisao = 0;

	public ThreadController(int idThread, Semaphore semaforo1, Semaphore semaforo2) {
		super();
		this.idThread = idThread;
		this.semaforo1 = semaforo1;
		this.semaforo2 = semaforo2;
		decisao = (int)(Math.random() * 2) + 1;
	}

	@Override
	public void run() {
		if (decisao == 1) {
			try {
				System.out.println("O avião " + idThread + " quer usar a pista Sul");
				semaforo1.acquire();
				Decolagem();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaforo1.release();
			}
		} else {
			try {
				System.out.println("O avião " + idThread + " quer usar a pista Norte");
				semaforo2.acquire();
				Decolagem();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaforo2.release();
			}
		}
	}

	public void Decolagem() {
		System.out.println("O avião " + idThread + " está manobrando...");
		manobra = (int) (Math.random() * 401) + 300;
		try {
			sleep(manobra);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O avião " + idThread + " está taxiando ");
		taxiar = (int) (Math.random() * 501) + 500;
		try {
			sleep(taxiar);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("O avião " + idThread + " está decolando ");
		decolagem = (int) (Math.random() * 201) + 600;
		try {
			sleep(decolagem);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("O avião " + idThread + " está se afastando ");
		afastamento = (int) (Math.random() * 501) + 300;
		try {
			sleep(afastamento);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pista liberada");
	}
}
