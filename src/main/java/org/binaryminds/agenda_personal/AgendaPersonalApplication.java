package org.binaryminds.agenda_personal;

import org.binaryminds.agenda_personal.dominio.service.IContactoService;
import org.binaryminds.agenda_personal.persistence.entity.Contacto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AgendaPersonalApplication implements CommandLineRunner {

	@Autowired
	private IContactoService contactoService;
	private static final Logger logger = LoggerFactory.getLogger(AgendaPersonalApplication.class);
	String sl = System.lineSeparator();
	public static void main(String[] args) {
		SpringApplication.run(AgendaPersonalApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		agendaPersonalApp();
	}

	private void agendaPersonalApp(){
		logger.info("**********************APLICACION DE AGENDA DE CONTACTOS PERSONAL**************************");
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(sl);
		}
	}
	private int mostrarMenu (Scanner consola){
		logger.info("""
				\n ****** AGENDA PERSONAL ******
				1. Ver lista de contactos.
				2. Buscar contacto por nombre.
				3. Agregar un nuevo contacto.
				4. Modificar contacto existente.
				5. Borrar contacto de la agenda.
				6. Salir.
				Elije una opcion: \s""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion){
			case 1->{
				logger.info(sl+"******LISTA DE TODOS LOS CONTACTOS*****");
				List<Contacto> contactos = contactoService.listarContactos();
				contactos.forEach(contacto -> logger.info(contacto.toString()+sl));
			}
			case 2 -> {
				logger.info(sl+"***BUSCAR CONTACTO POR NOMBRE***"+sl);
				logger.info("Ingrese el nombre: ");
				var nombre = consola.nextLine();
				Contacto contacto = contactoService.buscarContactoPorNombre(nombre);
				if (contacto != null){
					logger.info("Contacto encontrado: "+sl +contacto +sl);
				}else {
					logger.info("Contacto NO encontrado: "+sl +contacto +sl);
				}
			}
			case 3 ->{
				logger.info(sl+ "*** AGREGAR UN NUEVO CONTACTO ***" + sl);
				logger.info("Ingrese el nombre: ");
				var nombre = consola.nextLine();
				logger.info("Ingrese el telefono: ");
				var telefono = consola.nextLine();
				logger.info("Ingrese el correo: ");
				var correo = consola.nextLine();
				var contacto = new Contacto();
				contacto.setNombre(nombre);
				contacto.setTelefono(telefono);
				contacto.setCorreo(correo);
				contactoService.guardarContacto(contacto);
				logger.info("Contacto agregado: " + sl + contacto + sl);
			}
			case 4 ->{
				logger.info(sl+ "***** MODIFICAR CONTACTO EXISTENTE *****" + sl);
				logger.info("Ingrese el nombre del contacto a editar");
				var nb = consola.nextLine();
				Contacto contacto = contactoService.buscarContactoPorNombre(nb);
				if (contacto != null){
					logger.info("Ingrese el nombre: ");
					var nombre = consola.nextLine();
					logger.info("Ingrese el telefono: ");
					var telefono = consola.nextLine();
					logger.info("Ingrese el correo: ");
					var correo = consola.nextLine();
					contacto.setNombre(nombre);
					contacto.setTelefono(telefono);
					contacto.setCorreo(correo);
					contactoService.guardarContacto(contacto);
					logger.info("Contacto modificado: " + sl + contacto + sl);
				} else {
					logger.info("Contacto No encontrado: "+ sl + contacto + sl);

				}

			}
			case 5 ->{
				logger.info(sl+ "*** ELIMINAR CONTACTO ***" + sl );
				logger.info("Ingrese el nombre del contacto a eliminar");
				var nb = consola.nextLine();
				var contacto = contactoService.buscarContactoPorNombre(nb);
				if (contacto != null) {
					contactoService.eliminarContacto(contacto);
					logger.info("Contacto eliminado de la agenda: " + sl+contacto+sl);
				} else {
					logger.info("Contacto NO encontrado: " + sl + contacto + sl);
				}
			}
			case 6 ->{
				logger.info("Cerrando agenda, hasta pronto"+sl+sl);
				salir=true;
			}
			default -> logger.info("Opcion no valida!!!");
		}
		return salir;
	}


}
