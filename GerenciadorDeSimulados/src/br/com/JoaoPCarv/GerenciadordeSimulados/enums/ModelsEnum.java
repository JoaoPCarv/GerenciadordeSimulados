package br.com.JoaoPCarv.GerenciadordeSimulados.enums;

public enum ModelsEnum {

	ADMIN, STUDENT;

	public int getParamNumber() {

		switch (this) {

		case ADMIN:
			return 3;

		case STUDENT:
			return 0;

		}

		return 0;

	}

	public String getPath() {

		switch (this) {

		case ADMIN:
			return "C:\\Users\\Administrador.000\\.eclipse\\GerenciadorDeSimulados"
					+ "\\src\\br\\com\\JoaoPCarv\\GerenciadordeSimulados\\admins\\ADM";

		case STUDENT:
			return "";

		}

		return null;
	}

	public String getName() {

		switch (this) {

		case ADMIN:
			return "Administrador";

		case STUDENT:
			return "Estudante";

		}

		return null;
	}

}
