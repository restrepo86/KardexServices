import React from 'react';
import { Form, Row, Col, Input, Button } from 'antd';
import { observer } from 'mobx-react';
import 'moment/locale/es'

@observer
class ProductComponent extends React.Component {

  constructor(props) {
    super(props);
    this.process = this.props.stores.productStore.process;
    this.productStore = this.props.stores.productStore;
  };

  getFields() {

    const { getFieldDecorator } = this.props.form;
    const children = [];

    children.push(
      <Col span={6} key={0}>
        <Form.Item label={'Nombre'}>
          {getFieldDecorator('productName', {
            rules: [
              {
                required: false,
              },
            ],
          })(<Input placeholder="Ingrese un nombre para el producto" />)}
        </Form.Item>
      </Col>,
    );

    children.push(
      <Col span={6} key={1}>
        <Form.Item label={'Cantidad Mínima'}>
          {getFieldDecorator('minimumAmount', {
            rules: [
              {
                required: false,
              },
            ],
          })(<Input placeholder="Ingrese el mínimo de productos" />)}
        </Form.Item>
      </Col>,
    );

    children.push(
      <Col span={6} key={2}>
        <Form.Item label={'Cantidad Máxima'}>
          {getFieldDecorator('maximumAmount', {
            rules: [
              {
                required: false,
              },
            ],
          })(<Input placeholder="Ingrese el máximo de productos" />)}
        </Form.Item>
      </Col>,
    );

    children.push(
      <Col span={6} key={3}>
        <Form.Item label={'Valor Unitario'}>
          {getFieldDecorator('unitValue', {
            rules: [
              {
                required: false,
              },
            ],
          })(<Input placeholder="Ingrese el valor unitario del producto" />)}
        </Form.Item>
      </Col>,
    );

    return children;

  }

  handleSearch = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {

      console.log(values);
      this.productStore.saveProductStore(values);

    });
  };

  render() {

    return (

      <Form
        className="ant-advanced-search-form"
        onSubmit={this.handleSearch}
        layout='vertical'
      >
        <Row gutter={24}>{this.getFields()}</Row>
        <Row>
          <Col span={24} style={{ textAlign: 'right' }}>
            <center>
              <Button type="primary" htmlType="submit">
                Agregar Producto
              </Button>
            </center>
          </Col>
        </Row>
      </Form>

    );

  }
}

const WrappedSearchProductComponent = Form.create({ name: 'advanced_search' })(ProductComponent);

export default WrappedSearchProductComponent;