package view;

import java.util.concurrent.Semaphore;

import controller.ThreadController;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo1 = new Semaphore(permissoes);
		Semaphore semaforo2 = new Semaphore(permissoes);
		
		for (int idThread = 0; idThread < 12; idThread++) {
			Thread tCont = new ThreadController(idThread, semaforo1, semaforo2);
			tCont.start();
		}
	}

}
