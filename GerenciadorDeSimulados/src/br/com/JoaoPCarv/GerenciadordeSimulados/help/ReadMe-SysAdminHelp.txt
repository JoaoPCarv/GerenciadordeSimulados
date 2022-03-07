//WARNING: Rodar o seguinte trecho de código para criar o arquivo do SysAdmin, se ainda não criado:

try {
			
			System.out.println(new Administrador("SysAdmin_Master", IDFactory.generateID(
					"C:\\Users\\Administrador.000\\.eclipse\\GerenciadorDeSimulados"
							+ "\\src\\br\\com\\JoaoPCarv\\GerenciadordeSimulados\\admins\\"
							+ "ADM"), "12345678").recordThisOnTxt());
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
//