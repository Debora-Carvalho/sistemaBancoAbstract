package sistemaBancoAbstract;

public class ContaLimite extends Conta {
	private double limite = 500.00;

	@Override
	public boolean sacar(double valor) {
		if(valor <= this.saldo) {
			this.saldo -= valor;
			return true;
		} else if (valor > this.saldo || valor <= this.limite){
			double saldoTotal = saldo+limite;
			saldoTotal -= valor;
			
			if (saldoTotal < saldo) {
				this.saldo = 0;
				limite -= valor;
				return true;
			} else if (saldoTotal <= limite) {
				this.saldo = 0;
				limite = 0;
			} else {
				return false;
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean depositar(double valor) {
		if(valor >= 0) {
			this.saldo += valor;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean transferir(double valor, Conta outra) {
		if(valor <= this.saldo) {
			this.sacar(valor);
			outra.depositar(valor);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "ContaLimite [limite=" + limite + "]";
	}
	
	
}
