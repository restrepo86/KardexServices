import { observable, runInAction, action } from 'mobx';

export default class ProductStore {

  @observable process;
  @observable kardexServices;

  constructor(kardexServices, process) {
    this.process = process;
    this.kardexServices = kardexServices;
  }

  @action
  saveProductStore = (productRequestDTO) => {

    this.process.processDTO.loading = true;
    this.process.processDTO.loadingMessage = 'REGISTRANDO PRODUCTO...';
    
    this.kardexServices.saveProduct(productRequestDTO)
        .then(response => {
          runInAction(() => {
            const { data } = response;
            console.log(data)
            this.process.processDTO.loading = false;
          });
        })
        .catch(error => {
          const message = error.response ? error.response.headers.internalerrormessage 
          : new Error(error).message;
          this.process.showMessage(message, 'error');
          this.process.processDTO.loading = false;
        });

  };
}
